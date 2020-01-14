package ar.com.drk.drkspiderjava.gui.actions;

import java.awt.event.ActionEvent;

import ar.com.drk.drkspiderjava.gui.MainWindow;
import ar.com.drk.drkspiderjava.gui.ShowLinks;

public class ShowErrorLinks extends AbstractSpiderAction {
	private static final long serialVersionUID = 8865878898748851883L;

	public ShowErrorLinks(MainWindow wnd, String text) {
		super(wnd, text);
	}

	public void actionPerformed(ActionEvent e) {
		if (wnd.isThereSelectedNode())
			new ShowLinks(wnd, "Broken links...", wnd.getSelectedNode().getBrokenLinks(true));
	}

}
