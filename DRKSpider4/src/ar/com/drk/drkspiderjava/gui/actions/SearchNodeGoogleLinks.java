package ar.com.drk.drkspiderjava.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import ar.com.drk.drkspiderjava.DRKTools;
import ar.com.drk.drkspiderjava.gui.MainWindow;

public class SearchNodeGoogleLinks extends AbstractSpiderAction {
	private static final long serialVersionUID = -4424035248257321000L;

	public SearchNodeGoogleLinks(MainWindow wnd, String text) {
		super(wnd, text, new ImageIcon(SearchNodeGoogleLinks.class.getResource("/images/world_link.png")));
		putValue(AbstractAction.SHORT_DESCRIPTION, "Search links to this URL in Google index");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (wnd.isThereSelectedNode())
			DRKTools.showInBrowser("http://www.google.com/search?q=link:"+wnd.getSelectedNode().getURL().toString(), null);
	}

}
