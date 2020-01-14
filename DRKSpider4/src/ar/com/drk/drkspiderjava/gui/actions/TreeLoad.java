package ar.com.drk.drkspiderjava.gui.actions;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import ar.com.drk.drkspiderjava.DRKTools;
import ar.com.drk.drkspiderjava.gui.LoadTreeWorker;
import ar.com.drk.drkspiderjava.gui.MainWindow;

public class TreeLoad extends AbstractSpiderAction {
	private static final long serialVersionUID = -5715647942510706693L;

	public TreeLoad(MainWindow wnd, String text) {
		super(wnd, text, new ImageIcon(SEOReview.class.getResource("/images/load_tree.png")));
		putValue(AbstractAction.SHORT_DESCRIPTION, "Load tree from disk");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFileChooser chooser = new JFileChooser(DRKTools.prefs.get("tree_last_path", ""));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("DRKSpiderJava file", "drkspider");
	    chooser.setFileFilter(filter);
	    chooser.setApproveButtonText("Load");
	   
	    int returnVal = chooser.showOpenDialog(wnd);
	    if (returnVal == JFileChooser.APPROVE_OPTION) {

	    	File selectedFile = chooser.getSelectedFile();
    		DRKTools.prefs.put("tree_last_path", selectedFile.getParent());
    		
    		LoadTreeWorker worker = new LoadTreeWorker(wnd, selectedFile);
    		worker.execute();
	    }
	}

}
