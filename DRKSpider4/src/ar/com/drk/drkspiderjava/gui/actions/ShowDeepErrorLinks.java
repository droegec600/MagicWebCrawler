package ar.com.drk.drkspiderjava.gui.actions;

import java.awt.event.ActionEvent;

import ar.com.drk.drkspiderjava.gui.ErrorLinks;
import ar.com.drk.drkspiderjava.gui.MainWindow;

public class ShowDeepErrorLinks extends AbstractSpiderAction {
	private static final long serialVersionUID = 2650626689328938107L;

	public ShowDeepErrorLinks(MainWindow wnd, String text) {
		super(wnd, text);
	}

	public void actionPerformed(ActionEvent e) {
		if (wnd.isThereSelectedNode())
			new ErrorLinks(wnd, wnd.getSelectedNode().getErrorNodes(true));
	}
	
}
