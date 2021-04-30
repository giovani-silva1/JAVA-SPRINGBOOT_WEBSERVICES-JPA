package br.com.estudando.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudando.entidades.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@GetMapping
	public ResponseEntity<Usuario> findAll() {
		Usuario usuario = new Usuario(1, "Usuario 1", "usuario@email.com", "11 98788-7109", "1234");

		return ResponseEntity.ok().body(usuario);
	}

}
