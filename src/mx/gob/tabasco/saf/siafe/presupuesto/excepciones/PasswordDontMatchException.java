package mx.gob.tabasco.saf.siafe.presupuesto.excepciones;

public class PasswordDontMatchException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8879543596664059476L;

	/**
	 * 
	 */
	public PasswordDontMatchException() {
		super();
	}
	
	/**
	 * 
	 * @param msg
	 */
	public PasswordDontMatchException(String msg) {
		super(msg);
	}
	
}
