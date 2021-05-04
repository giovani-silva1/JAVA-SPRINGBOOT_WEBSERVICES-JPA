package br.com.estudando.services.exception;

public class RegistroNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public RegistroNaoEncontradoException(Long id) {
		super("Registro não encontrado :" + id);
	}

	
}
