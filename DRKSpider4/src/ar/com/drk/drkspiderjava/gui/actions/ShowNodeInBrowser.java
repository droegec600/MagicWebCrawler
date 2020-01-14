package ar.com.drk.drkspiderjava.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import ar.com.drk.drkspiderjava.DRKTools;
import ar.com.drk.drkspiderjava.gui.MainWindow;

public class ShowNodeInBrowser extends AbstractSpiderAction {
	private static final long serialVersionUID = -6948588469727477764L;

	public ShowNodeInBrowser(MainWindow wnd, String text) {
		super(wnd, text, new ImageIcon(ShowNodeInBrowser.class.getResource("/images/link_go.png")));
		putValue(AbstractAction.SHORT_DESCRIPTION, "Open this URL in your default browser");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (wnd.isThereSelectedNode())
			DRKTools.showInBrowser(wnd.getSelectedNode().getURL().toString(), null);
	}

}
