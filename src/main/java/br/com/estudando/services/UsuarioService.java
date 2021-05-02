package br.com.estudando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudando.entidades.Usuario;
import br.com.estudando.repositorys.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario encontrarUsuarioPorId(Long id) {
		Optional<Usuario> usuarioEncontrario = usuarioRepository.findById(id);
		return usuarioEncontrario.get();

	}
}
