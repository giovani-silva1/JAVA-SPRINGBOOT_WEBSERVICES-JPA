package br.com.estudando.controllers;

import java.net.URI;
import java.util.List;

import org.hibernate.engine.spi.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping()
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario novoUsuario) {
		Usuario novoUsuarioCadastrado = usuarioService.criarUsuario(novoUsuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(novoUsuarioCadastrado.getId()).toUri();
		return ResponseEntity.created(uri).body(usuarioService.criarUsuario(novoUsuario));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
		usuarioService.deletarUsuario(id);
		return ResponseEntity.noContent().build();
	}
}
