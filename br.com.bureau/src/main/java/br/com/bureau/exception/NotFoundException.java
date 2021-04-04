package br.com.bureau.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String mens) {
		super(mens);

	}
}
