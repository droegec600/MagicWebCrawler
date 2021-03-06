package com.droegec.mwc.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListDataListener;

import com.droegec.mwc.DRKTools;
import com.droegec.mwc.ProgressListener;
import com.droegec.mwc.model.DRKLink;
import com.droegec.mwc.model.WebTreeNode;

@SuppressWarnings("serial")
public class HTMLInfoPane extends JPanel {

	final private WebTreeNode nodo;
	final private ProgressListener progress;
	private JLabel lbl_size = null;
	private JLabel size = null;
	private JLabel lbl_content_type = null;
	private JLabel contenttype = null;
	private JScrollPane src_scroll = null;
	private JTextArea source = null;
	private JScrollPane links_scroll = null;
	private JList<DRKLink> links = null;
	private JToolBar html_toolbar = null;
	private JButton navigate = null;
	private JButton google_links = null;
	private JLabel lblStatus = null;
	private JTextField status = null;
	private JLabel lblpr = null;
	private JTextField keywords = null;
	private JLabel lbldesc = null;
	private JLabel lbltitle = null;
	private JTextField html_title = null;
	private JTextField html_desc = null;
	private JLabel lblaut = null;
	private JTextField html_author = null;
	private JLabel lblicon = null;
	private JLabel icon = null;
	private JButton yahoo_links = null;
	private JLabel lblil = null;
	private JLabel lblel = null;
	private JLabel lblnl = null;
	private JLabel internal_links = null;
	private JLabel external_links = null;
	private JLabel nofollow_links = null;
	
	/**
	 * This is the default constructor
	 * @param wnd 
	 */
	public HTMLInfoPane(MainWindow wnd, WebTreeNode nodo, ProgressListener progress) {
		super();
		this.nodo = nodo;
		this.progress = progress;
		initialize();
		
                //getHtml_toolbar().add(wnd.getActionSEO());
		
		contenttype.setText(nodo.getContentType());
		size.setText(String.valueOf(nodo.getSize())+" bytes");
		status.setText(nodo.getStatus()+" - "+nodo.getError());
		links.setModel(new ListModel<DRKLink>() {
			public int getSize() {
				return HTMLInfoPane.this.nodo.getLinks().size();
			}

			public DRKLink getElementAt(int index) {
				return HTMLInfoPane.this.nodo.getLinks().get(index);
			}

			public void addListDataListener(ListDataListener l) {
			}

			public void removeListDataListener(ListDataListener l) {
			}
			
		});
		
		getSourceHTML();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints62 = new GridBagConstraints();
		gridBagConstraints62.gridx = 3;
		gridBagConstraints62.anchor = GridBagConstraints.WEST;
		gridBagConstraints62.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints62.gridy = 10;
		nofollow_links = new JLabel();
		nofollow_links.setText("0");
		GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
		gridBagConstraints51.gridx = 3;
		gridBagConstraints51.anchor = GridBagConstraints.WEST;
		gridBagConstraints51.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints51.gridy = 9;
		external_links = new JLabel();
		external_links.setText("0");
		GridBagConstraints gridBagConstraints42 = new GridBagConstraints();
		gridBagConstraints42.gridx = 3;
		gridBagConstraints42.anchor = GridBagConstraints.WEST;
		gridBagConstraints42.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints42.gridy = 8;
		internal_links = new JLabel();
		internal_links.setText("0");
		GridBagConstraints gridBagConstraints32 = new GridBagConstraints();
		gridBagConstraints32.gridx = 2;
		gridBagConstraints32.anchor = GridBagConstraints.EAST;
		gridBagConstraints32.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints32.gridy = 10;
		lblnl = new JLabel();
		lblnl.setText("No follow links:");
		GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
		gridBagConstraints24.gridx = 2;
		gridBagConstraints24.anchor = GridBagConstraints.EAST;
		gridBagConstraints24.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints24.gridy = 9;
		lblel = new JLabel();
		lblel.setText("External links:");
		GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
		gridBagConstraints15.gridx = 2;
		gridBagConstraints15.anchor = GridBagConstraints.EAST;
		gridBagConstraints15.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints15.gridy = 8;
		lblil = new JLabel();
		lblil.setText("Internal links:");
		GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
		gridBagConstraints8.gridx = 3;
		gridBagConstraints8.anchor = GridBagConstraints.WEST;
		gridBagConstraints8.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints8.gridy = 7;
		icon = new JLabel();
		icon.setText("");
		GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
		gridBagConstraints7.gridx = 2;
		gridBagConstraints7.anchor = GridBagConstraints.EAST;
		gridBagConstraints7.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints7.gridy = 7;
		lblicon = new JLabel();
		lblicon.setText("Icon:");
		GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
		gridBagConstraints61.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints61.gridy = 6;
		gridBagConstraints61.weightx = 0.7;
		gridBagConstraints61.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints61.gridx = 3;
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.gridx = 2;
		gridBagConstraints5.anchor = GridBagConstraints.EAST;
		gridBagConstraints5.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints5.gridy = 6;
		lblaut = new JLabel();
		lblaut.setText("Author:");
		GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
		gridBagConstraints41.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints41.gridy = 4;
		gridBagConstraints41.weightx = 0.7;
		gridBagConstraints41.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints41.gridx = 3;
		GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
		gridBagConstraints31.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints31.gridy = 3;
		gridBagConstraints31.weightx = 0.7;
		gridBagConstraints31.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints31.gridx = 3;
		GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
		gridBagConstraints23.gridx = 2;
		gridBagConstraints23.anchor = GridBagConstraints.EAST;
		gridBagConstraints23.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints23.gridy = 3;
		lbltitle = new JLabel();
		lbltitle.setText("Title:");
		GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
		gridBagConstraints14.gridx = 2;
		gridBagConstraints14.anchor = GridBagConstraints.EAST;
		gridBagConstraints14.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints14.gridy = 4;
		lbldesc = new JLabel();
		lbldesc.setText("Description:");
		GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
		gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints6.gridy = 5;
		gridBagConstraints6.weightx = 0.7;
		gridBagConstraints6.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints6.gridx = 3;
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.gridx = 2;
		gridBagConstraints4.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints4.anchor = GridBagConstraints.EAST;
		gridBagConstraints4.gridy = 5;
		lblpr = new JLabel();
		lblpr.setText("Keywords:");
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints3.gridy = 1;
		gridBagConstraints3.weightx = 1.0;
		gridBagConstraints3.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints3.gridwidth = 3;
		gridBagConstraints3.gridx = 1;
		GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
		gridBagConstraints22.gridx = 0;
		gridBagConstraints22.anchor = GridBagConstraints.EAST;
		gridBagConstraints22.insets = new Insets(3, 3, 3, 3);
		gridBagConstraints22.gridy = 1;
		lblStatus = new JLabel();
		lblStatus.setText("Status:");
		GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
		gridBagConstraints12.fill = GridBagConstraints.BOTH;
		gridBagConstraints12.gridy = 0;
		gridBagConstraints12.weightx = 1.0;
		gridBagConstraints12.gridwidth = 4;
		gridBagConstraints12.gridx = 0;
		GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
		gridBagConstraints13.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints13.gridy = 4;
		gridBagConstraints13.weightx = 0.3;
		gridBagConstraints13.weighty = 0.3;
		gridBagConstraints13.gridwidth = 2;
		gridBagConstraints13.gridheight = 7;
		gridBagConstraints13.gridx = 0;
		GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
		gridBagConstraints21.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints21.gridy = 11;
		gridBagConstraints21.weightx = 1.0;
		gridBagConstraints21.weighty = 0.7;
		gridBagConstraints21.insets = new java.awt.Insets(3,3,3,3);
		gridBagConstraints21.gridwidth = 4;
		gridBagConstraints21.gridx = 0;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 1;
		gridBagConstraints2.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints2.insets = new java.awt.Insets(3,3,3,3);
		gridBagConstraints2.gridy = 2;
		contenttype = new JLabel();
		contenttype.setText("");
		GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
		gridBagConstraints11.gridx = 0;
		gridBagConstraints11.insets = new java.awt.Insets(3,3,3,3);
		gridBagConstraints11.anchor = GridBagConstraints.EAST;
		gridBagConstraints11.gridy = 2;
		lbl_content_type = new JLabel();
		lbl_content_type.setText("Content type:");
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.insets = new java.awt.Insets(3,3,3,3);
		gridBagConstraints1.fill = java.awt.GridBagConstraints.NONE;
		gridBagConstraints1.weightx = 0.3;
		gridBagConstraints1.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints1.gridy = 3;
		size = new JLabel();
		size.setText("0 bytes");
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.insets = new java.awt.Insets(3,3,3,3);
		gridBagConstraints.weightx = 0.0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.gridy = 3;
		lbl_size = new JLabel();
		lbl_size.setText("Size:");
		this.setLayout(new GridBagLayout());
		this.setSize(747, 381);
		this.add(lbl_size, gridBagConstraints);
		this.add(size, gridBagConstraints1);
		this.add(lbl_content_type, gridBagConstraints11);
		this.add(contenttype, gridBagConstraints2);
		this.add(getSrc_scroll(), gridBagConstraints21);
		this.add(getLinks_scroll(), gridBagConstraints13);
		this.add(getHtml_toolbar(), gridBagConstraints12);
		this.add(lblStatus, gridBagConstraints22);
		this.add(getStatus(), gridBagConstraints3);
		this.add(lblpr, gridBagConstraints4);
		this.add(getKeywords(), gridBagConstraints6);
		this.add(lbldesc, gridBagConstraints14);
		this.add(lbltitle, gridBagConstraints23);
		this.add(getHtml_title(), gridBagConstraints31);
		this.add(getHtml_desc(), gridBagConstraints41);
		this.add(lblaut, gridBagConstraints5);
		this.add(getHtml_author(), gridBagConstraints61);
		this.add(lblicon, gridBagConstraints7);
		this.add(icon, gridBagConstraints8);
		this.add(lblil, gridBagConstraints15);
		this.add(lblel, gridBagConstraints24);
		this.add(lblnl, gridBagConstraints32);
		this.add(internal_links, gridBagConstraints42);
		this.add(external_links, gridBagConstraints51);
		this.add(nofollow_links, gridBagConstraints62);
	}

	protected void getSourceHTML() {
		new Thread() {
			@Override
			public void run() {
				HTMLInfoPane.this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				final String html = nodo.getSource(progress);
				String url = null;
				if (nodo.getRel("shortcut icon") != null) {
					if (!nodo.getRel("shortcut icon").startsWith("http://"))
						url = nodo.getURL().getProtocol()+"://"+nodo.getURL().getHost()+nodo.getURL().getPath() + nodo.getRel("shortcut icon");
					else
						url = nodo.getRel("shortcut icon");
				}
				final String icon_url = url;
				
				SwingUtilities.invokeLater(new Runnable() {
					
					public void run() {
						source.setText(html); source.setCaretPosition(0);
						if (icon_url != null) {
							try {
								icon.setIcon(new ImageIcon(new URL(icon_url)));
							} catch (MalformedURLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						html_title.setText(nodo.getTitle()); html_title.setCaretPosition(0);
						html_desc.setText(nodo.getMeta("Description").toString()); html_desc.setCaretPosition(0);
						keywords.setText(nodo.getMeta("Keywords").toString()); keywords.setCaretPosition(0);
						html_author.setText(nodo.getMeta("Author").toString()); html_author.setCaretPosition(0);
						internal_links.setText(String.valueOf(nodo.getInternalLinkCount()));
						external_links.setText(String.valueOf(nodo.getExternalLinkCount()));
						nofollow_links.setText(String.valueOf(nodo.getNofollowLinkCount()));
						HTMLInfoPane.this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					}
				});
			}
		}.start();
	}

	/**
	 * This method initializes src_scroll	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getSrc_scroll() {
		if (src_scroll == null) {
			src_scroll = new JScrollPane();
			src_scroll.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HTML", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			src_scroll.setViewportView(getSource());
		}
		return src_scroll;
	}

	/**
	 * This method initializes source	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getSource() {
		if (source == null) {
			source = new JTextArea();
			source.setColumns(50);
			source.setEditable(false);
			source.setRows(12);
		}
		return source;
	}

	/**
	 * This method initializes links_scroll	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getLinks_scroll() {
		if (links_scroll == null) {
			links_scroll = new JScrollPane();
			links_scroll.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Links", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			links_scroll.setViewportView(getLinks());
		}
		return links_scroll;
	}

	/**
	 * This method initializes links	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList<DRKLink> getLinks() {
		if (links == null) {
			links = new JList<DRKLink>();
			links.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
			links.setVisibleRowCount(6);
			links.setCellRenderer(new MyCellRenderer());
		}
		return links;
	}

	class MyCellRenderer extends JLabel implements ListCellRenderer<DRKLink> {
		public MyCellRenderer() {
	         setOpaque(true);
	     }
	     // This is the only method defined by ListCellRenderer.
	     // We just reconfigure the JLabel each time we're called.

		@Override
	     public Component getListCellRendererComponent(
	       JList<? extends DRKLink> list,
	       DRKLink value,            // value to display
	       int index,               // cell index
	       boolean isSelected,      // is the cell selected
	       boolean cellHasFocus)    // the list and the cell have the focus
	     {
	         DRKLink l = (DRKLink)value;
	         setText(l.getURL().toString());
	         if (l.isExternal()) {
	        	 if (isSelected) {
		        	 setBackground(list.getSelectionBackground());
		             setForeground(Color.ORANGE);
		         }
		         else {
		        	 setBackground(list.getBackground());
		             setForeground(Color.ORANGE);
		         }
	         }
	         else if (l.isNoFollow()) {
	        	 if (isSelected) {
		        	 setBackground(Color.GRAY);
		             setForeground(Color.BLUE);
		         }
		         else {
		        	 setBackground(list.getBackground());
		             setForeground(Color.BLUE);
		         }
	         }
	         else {
	        	 if (isSelected) {
		        	 setBackground(list.getSelectionBackground());
		             setForeground(list.getForeground());
		         }
		         else {
		        	 setBackground(list.getBackground());
		             setForeground(list.getForeground());
		         }
	         }
	         setEnabled(list.isEnabled());
	         setFont(list.getFont());
	         return this;
	     }
	 }
	
	/**
	 * This method initializes html_toolbar	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getHtml_toolbar() {
		if (html_toolbar == null) {
			html_toolbar = new JToolBar();
			html_toolbar.setFloatable(false);
			html_toolbar.add(getNavigate());
			html_toolbar.add(getGoogle_links());
			html_toolbar.add(getYahoo_links());
		}
		return html_toolbar;
	}

	/**
	 * This method initializes navigate	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getNavigate() {
		if (navigate == null) {
			navigate = new JButton();
			navigate.setText("Open in browser");
			navigate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DRKTools.showInBrowser(nodo.getURL().toString(), null);
				}
			});
		}
		return navigate;
	}

	/**
	 * This method initializes google_links	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getGoogle_links() {
		if (google_links == null) {
			google_links = new JButton();
			google_links.setText("Google links");
			google_links.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DRKTools.showInBrowser("http://www.google.com/search?q=link:"+nodo.getURL().toString(), null);
				}
			});
		}
		return google_links;
	}

	/**
	 * This method initializes status	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getStatus() {
		if (status == null) {
			status = new JTextField();
			status.setEditable(false);
		}
		return status;
	}

	/**
	 * This method initializes keywords	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getKeywords() {
		if (keywords == null) {
			keywords = new JTextField();
			keywords.setEditable(false);
		}
		return keywords;
	}

	/**
	 * This method initializes html_title	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getHtml_title() {
		if (html_title == null) {
			html_title = new JTextField();
			html_title.setEditable(false);
		}
		return html_title;
	}

	/**
	 * This method initializes html_desc	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getHtml_desc() {
		if (html_desc == null) {
			html_desc = new JTextField();
			html_desc.setEditable(false);
		}
		return html_desc;
	}

	/**
	 * This method initializes html_author	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getHtml_author() {
		if (html_author == null) {
			html_author = new JTextField();
			html_author.setEditable(false);
		}
		return html_author;
	}

	/**
	 * This method initializes yahoo_links	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getYahoo_links() {
		if (yahoo_links == null) {
			yahoo_links = new JButton();
			yahoo_links.setText("Yahoo! links"); 
			yahoo_links.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DRKTools.showInBrowser("http://siteexplorer.search.yahoo.com/search?p="+nodo.getURL().toString(), null);
				}
			});
		}
		return yahoo_links;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
