package ar.com.drk.drkspiderjava.gui.actions;

import java.awt.event.ActionEvent;

import ar.com.drk.drkspiderjava.gui.MainWindow;
import ar.com.drk.drkspiderjava.gui.SearchNodesDlg;
import ar.com.drk.drkspiderjava.gui.ShowNodes;

public class SearchNodes extends AbstractSpiderAction {
	private static final long serialVersionUID = -1198095486157419863L;

	public SearchNodes(MainWindow wnd, String text) {
		super(wnd, text);
	}

	public void actionPerformed(ActionEvent e) {
		if (wnd.isThereSelectedNode()) {
			SearchNodesDlg dlg = new SearchNodesDlg(wnd);
			if (dlg.ok) {
				new ShowNodes(wnd, "Error links", wnd.getSelectedNode().getNodesMatching(dlg.title, dlg.title_regex, dlg.description, dlg.description_regex, 
						dlg.keywords, dlg.keywords_regex, dlg.author, dlg.author_regex, dlg.noindex));
			}
		}
	}

}
