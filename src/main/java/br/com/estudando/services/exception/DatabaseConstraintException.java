package br.com.estudando.services.exception;

public class DatabaseConstraintException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DatabaseConstraintException(String sms) {
		super(sms);
	}
}
