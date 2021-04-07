package br.com.bureau.exception;

public class ConflictedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ConflictedException(String message) {
		super(message);
	}

}
