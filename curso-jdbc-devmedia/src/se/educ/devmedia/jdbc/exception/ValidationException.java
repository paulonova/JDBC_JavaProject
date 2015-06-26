package se.educ.devmedia.jdbc.exception;

public class ValidationException extends Exception {

	/**
	 * Class who works with the exceptions and show messages..
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ValidationException(String msg) {
		
		super(msg);
		
	}
	
	public ValidationException(String msg, Exception ex) {
		
		super(msg, ex);
	}


}
