package br.com.estudando.controllers.exception;

import java.io.Serializable;
import java.time.Instant;

public class ResponseException implements Serializable {

	private static final long serialVersionUID = 1L;
	
		private Instant horario;
		private Integer status;
		private String erro;
		private String mensagem;
		private String path;
		
		public ResponseException() {
			
		}

		public ResponseException(Instant horario, Integer status, String erro, String mensagem, String path) {
		
			this.horario = horario;
			this.status = status;
			this.erro = erro;
			this.mensagem = mensagem;
			this.path = path;
		}

		public Instant getHorario() {
			return horario;
		}

		public void setHorario(Instant horario) {
			this.horario = horario;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public String getErro() {
			return erro;
		}

		public void setErro(String erro) {
			this.erro = erro;
		}

		public String getMensagem() {
			return mensagem;
		}

		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}
		
		
		

}
