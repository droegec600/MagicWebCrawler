package ar.com.drk.drkspiderjava.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import ar.com.drk.drkspiderjava.gui.MainWindow;

public class SiteWideSeoReview extends AbstractSpiderAction {
	private static final long serialVersionUID = 9029528498084641862L;

	public SiteWideSeoReview(MainWindow wnd, String text) {
		super(wnd, text, new ImageIcon(SEOReview.class.getResource("/images/site_wide_seo.png")));
		putValue(AbstractAction.SHORT_DESCRIPTION, "Show SEO analysis for this website");
	}

	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(wnd, "The overall score for this site is "+wnd.getDocument().getSEOResult().getResult()+"%", "Site wide SEO", JOptionPane.INFORMATION_MESSAGE);
	}

}
