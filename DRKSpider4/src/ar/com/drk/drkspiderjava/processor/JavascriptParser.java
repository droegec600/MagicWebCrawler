package ar.com.drk.drkspiderjava.processor;

import ar.com.drk.drkspiderjava.ProgressListener;
import ar.com.drk.drkspiderjava.model.WebTreeModel;
import ar.com.drk.drkspiderjava.model.WebTreeNode;

public class JavascriptParser extends Parser {
	private static final long serialVersionUID = 2117595161043889364L;

	public JavascriptParser(WebTreeNode nodo,  WebTreeModel model) {
		super(nodo, model);
	}
	
	/**
	 * Inicia el procesamiento de la URL.
	 * El parser obtiene los links de la URL con el que fue instanciado.
	 */
	public void parse() {
				
		nodeContent(null); // Proceso la descarga del contenido
	}

	/* (non-Javadoc)
	 * @see ar.com.drk.drkspiderjava.processor.Parser#findURLs()
	 */
	@Override
	protected void findURLs() {
	}
	
	/* (non-Javadoc)
	 * @see ar.com.drk.drkspiderjava.processor.Parser#getSource(ProgressListener progress)
	 */
	@Override
	public String getSource(ProgressListener progress) {
		return nodeContent(progress);
	}

	@Override
	public String getParserMIMEType() {
		return "text/javascript.*";
	}
	
	@Override
	public void finishedGetContent(String content, boolean ok) {
	}	
}
