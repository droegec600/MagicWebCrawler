package ar.com.drk.drkspiderjava.gui.panes;

import javax.swing.JPanel;

import ar.com.drk.drkspiderjava.model.DRKLink;
import ar.com.drk.drkspiderjava.model.NodeTextLocation;

public abstract class InfoPane extends JPanel {
	private static final long serialVersionUID = 1531186708101697227L;

	abstract public void locateLink(DRKLink link);

	abstract public void locateContent(NodeTextLocation gotoContent);
}
