package se.educ.devmedia.jdbc.exception;

public class PersistenceExceptions extends Exception {

	/**
	 * Class of Exceptions..
	 */
	private static final long serialVersionUID = 6073645508410566771L;
	
	public PersistenceExceptions(String msg) {
		
		super(msg);
		
	}
	
	public PersistenceExceptions(String msg, Exception ex) {
		
		super(msg, ex);
	}

}
