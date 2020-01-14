package ar.com.drk.drkspiderjava.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import ar.com.drk.drkspiderjava.gui.MainWindow;
import ar.com.drk.drkspiderjava.gui.SEOReviewDlg;

public class SEOReview extends AbstractSpiderAction {
	private static final long serialVersionUID = 4457264615083190785L;

	public SEOReview(MainWindow wnd, String text) {
		super(wnd, text, new ImageIcon(SEOReview.class.getResource("/images/seo.png")));
		putValue(AbstractAction.SHORT_DESCRIPTION, "Show SEO analysis for this node");
	}

	public void actionPerformed(ActionEvent e) {
		if (wnd.isThereSelectedNode())
			new SEOReviewDlg(wnd, wnd.getSelectedNode());
	}

}
