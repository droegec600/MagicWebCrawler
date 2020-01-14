package ar.com.drk.drkspiderjava.exceptions;

public class CrawlerInterruptedException extends Exception {

	private static final long serialVersionUID = 3648067615633621384L;

	public CrawlerInterruptedException(String message, Throwable e) {
		super(message, e);
	}
}
