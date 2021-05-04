package br.com.estudando.controllers.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.estudando.services.exception.RegistroNaoEncontradoException;

@ControllerAdvice
public class RequestExceptionHandler {

	@ExceptionHandler(RegistroNaoEncontradoException.class)
	public ResponseEntity<ResponseException> registroNaoEncontrado(RegistroNaoEncontradoException e, HttpServletRequest request){
	String erro = "Registro não encontrado";
	HttpStatus status = HttpStatus.NOT_FOUND;
	ResponseException responseException = new ResponseException(Instant.now(),status.value(),erro,e.getMessage(),request.getRequestURI());
	return ResponseEntity.status(status).body(responseException);
	}
}
