package ar.com.drk.drkspiderjava.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import ar.com.drk.drkspiderjava.gui.MainWindow;
import ar.com.drk.drkspiderjava.gui.SearchWithGoogle;

public class GoogleSearch extends AbstractSpiderAction {
	private static final long serialVersionUID = -215590814971257589L;

	public GoogleSearch(MainWindow wnd, String text) {
		super(wnd, text, new ImageIcon(SearchNodeGoogleLinks.class.getResource("/images/find.png")));
		putValue(AbstractAction.SHORT_DESCRIPTION, "Search within this domain using Google index");
	}

	public void actionPerformed(ActionEvent e) {
		if (wnd.isThereSelectedNode())
			new SearchWithGoogle(wnd, wnd.getSelectedNode().getURL().toString());
	}

}
