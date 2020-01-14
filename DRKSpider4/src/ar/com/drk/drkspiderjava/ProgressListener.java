package ar.com.drk.drkspiderjava;

public interface ProgressListener {

	/**
	 * Indica el progreso actual.
	 * @param percent un número entre 0.0 y 1.0
	 */
	public void setProgress(float percent, String status);
	
	/**
	 * Indica que se está trabajando sin saber el total de trabajo a realizar.
	 * @param unknown
	 */
	public void setUnknownProgress(boolean unknown, String status);
	
	
}
