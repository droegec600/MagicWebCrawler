package com.droegec.mwc.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

import com.droegec.mwc.DRKTools;
import com.droegec.mwc.gui.helpers.TablePreferences;
import com.droegec.mwc.gui.helpers.WebTreeNodeTableModel;
import com.droegec.mwc.model.WebTreeNode;
import com.droegec.mwc.model.exporters.CSVExporter;
import com.droegec.mwc.model.exporters.Exporter;

public class ShowNodes extends JDialog implements ListSelectionListener {
	private static final long serialVersionUID = 3588614949379078595L;
	private final JPanel contentPanel = new JPanel();
	private final List<WebTreeNode> nodes;
	private TableModel model;
	private final JTable table;
	private final Action action_go = new SwingAction();
	
	/**
	 * Create the dialog.
	 * 
	 */
	public ShowNodes(Frame owner, String title, List<WebTreeNode> errors) {
		super(owner);
		this.nodes = errors;
		model =  new WebTreeNodeTableModel(nodes);
		table = new JTable(model);
		setTitle(title);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane();
		contentPanel.setLayout(new BorderLayout());
		scrollPane.setViewportView(table);
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowNodes.this.dispatchEvent(new WindowEvent(ShowNodes.this, WindowEvent.WINDOW_CLOSING));
			}
		});
		JButton btnGo = new JButton("Show...");
		btnGo.setEnabled(false);
		btnGo.setAction(action_go);
		buttonPane.add(btnGo);
		
		JButton btnExport = new JButton("Export...");
		btnExport.setAction(new ExportAction());
		buttonPane.add(btnExport);
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(this);
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        if (evt.getClickCount() == 2 && action_go.isEnabled()) {
		        	action_go.actionPerformed(new ActionEvent(evt, 0, ""));
		        }
		    }
		});		
		new TablePreferences(table, WebTreeNode.class);
		setLocation(DRKTools.getCenterLocation(this));
		setVisible(true);
	}

	private class SwingAction extends AbstractAction {
		private static final long serialVersionUID = 2094257015305105483L;
		public SwingAction() {
			setEnabled(false);
			putValue(NAME, "Locate");
			putValue(SHORT_DESCRIPTION, "Go to node");
		}
		public void actionPerformed(ActionEvent e) {
			((MainWindow)getOwner()).gotoNode(ShowNodes.this.nodes.get(table.getSelectionModel().getMinSelectionIndex()));
		}
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		action_go.setEnabled(table.getSelectionModel().getMinSelectionIndex() >= 0);
	}
	
	private class ExportAction extends AbstractAction {
		private static final long serialVersionUID = -5153246048263140087L;
		public ExportAction() {
			putValue(NAME, "Export...");
			putValue(SHORT_DESCRIPTION, "Export this data");
		}
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser(DRKTools.prefs.get("export_last_path", ""));
			FileNameExtensionFilter filter;
			Exporter exporter;
	    	filter = new FileNameExtensionFilter("CSV file", "csv");
	    	exporter = new CSVExporter(null, nodes);
		    chooser.setFileFilter(filter);
		    chooser.setApproveButtonText("Export");
		   
		    int returnVal = chooser.showSaveDialog(ShowNodes.this);
		    if (returnVal == JFileChooser.APPROVE_OPTION) {
		    	
		    	File selectedFile = chooser.getSelectedFile();
		    	
		    	// Si no tiene la extensión, se la agrego
				if (!selectedFile.getName().endsWith("."+filter.getExtensions()[0]))
					selectedFile = new File(selectedFile.getAbsolutePath()+"."+filter.getExtensions()[0]);
		    	
		    	// Confirm overwrite
		    	if (selectedFile.exists())
		    		if (JOptionPane.showConfirmDialog(ShowNodes.this, "The file "+selectedFile.getName()+" already exists. Do you want to overwrite?", "Confirm overwrite", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.NO_OPTION)
		    			return;
		    		
		    	try {
					exporter.exportNodesFirstLevel(selectedFile.getAbsolutePath());
		    		
		    		// Save defaults
		    		DRKTools.prefs.put("export_last_path", selectedFile.getParent());
		    		
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(ShowNodes.this, e1.getLocalizedMessage(), "Error during export", JOptionPane.ERROR_MESSAGE);
				}
		    }
			
		}
	}
	
}
