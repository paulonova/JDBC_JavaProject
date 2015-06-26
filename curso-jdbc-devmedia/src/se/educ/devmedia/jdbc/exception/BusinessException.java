package se.educ.devmedia.jdbc.exception;

public class BusinessException extends Exception {

	/**
	 * Class who works with the exceptions and show messages..
	 */
	private static final long serialVersionUID = 1L;
	
	
	public BusinessException(String msg) {
		
		super(msg);
		
	}
	
	public BusinessException(String msg, Exception ex) {
		
		super(msg, ex);
	}


}
