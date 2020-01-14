package ar.com.drk.drkspiderjava.gui.actions;

import java.awt.event.ActionEvent;

import ar.com.drk.drkspiderjava.gui.MainWindow;
import ar.com.drk.drkspiderjava.gui.SearchLinksDlg;
import ar.com.drk.drkspiderjava.gui.ShowLinks;

public class SearchLinksTo extends AbstractSpiderAction {
	private static final long serialVersionUID = -1198095486157419863L;

	public SearchLinksTo(MainWindow wnd, String text) {
		super(wnd, text);
	}

	public void actionPerformed(ActionEvent e) {
		if (wnd.isThereSelectedNode()) {
			SearchLinksDlg dlg = new SearchLinksDlg(wnd);
			if (dlg.ok) {
				new ShowLinks(wnd, "Link search...", wnd.getSelectedNode().getLinksTo(dlg.tag, dlg.url, dlg.url_regex, dlg.anchor, dlg.anchor_regex, dlg.error, dlg.nofollow, dlg.external));
			}
		}
	}

}
