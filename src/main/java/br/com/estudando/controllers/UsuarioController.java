package br.com.estudando.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudando.entidades.Usuario;
import br.com.estudando.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> encontrarTodosUsuarios() {
		List<Usuario> usuariosEncontrados = usuarioService.listarUsuarios();

		return ResponseEntity.ok().body(usuariosEncontrados);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> encontrarUsuarioPorId(@PathVariable Long id) {
		Usuario usuarioEncontrado = usuarioService.encontrarUsuarioPorId(id);
		return ResponseEntity.ok().body(usuarioEncontrado);
	}
}
