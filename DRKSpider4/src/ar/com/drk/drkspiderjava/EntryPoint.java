package ar.com.drk.drkspiderjava;

import javax.swing.UIManager;

import ar.com.drk.drkspiderjava.gui.MainWindow;

/**
 * Punto de entrada a la aplicación.
 * 
 * @author _Leo_
 */
public class EntryPoint {

	/**
	 * Inicializa la aplicación
	 * @param args
	 */
	public static void main(String[] args) {
		// Lanzamos la GUI y terminamos...
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}
	
	/**
	 * Muestra la ventana principal.
	 *
	 */
    private static void createAndShowGUI() {

    	// Look and feel default de la plataforma
        try {
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }

        // Lanzamos la ventana principal
        MainWindow wnd = new MainWindow();
        wnd.setVisible(true);
    }

}
