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

	public Usuario criarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
		Usuario usuario = usuarioRepository.getOne(id);
		atualizarUsuario(usuario, usuarioAtualizado);
		return usuarioRepository.save(usuario);

	}

	private void atualizarUsuario(Usuario usuario, Usuario usuarioAtualizado) {
		usuario.setNome(usuarioAtualizado.getNome());
		usuario.setEmail(usuarioAtualizado.getEmail());
		usuario.setTelefone(usuarioAtualizado.getTelefone());
		usuario.setSenha(usuarioAtualizado.getSenha());

	}

}
