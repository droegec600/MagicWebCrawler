package ar.com.drk.drkspiderjava.gui;

import javax.swing.JPanel;

import ar.com.drk.drkspiderjava.ProgressListener;
import ar.com.drk.drkspiderjava.model.WebTreeNode;

public class InfoPaneFactory {

	static public JPanel getInfoPane(MainWindow wnd, WebTreeNode node, ProgressListener progress) {
		
		if (node.getContentType() != null && node.getContentType().startsWith("text/html"))
			return new HTMLInfoPane(wnd, node, progress);
		
		return new GenericNodeInfoPane(node);
	}
}
