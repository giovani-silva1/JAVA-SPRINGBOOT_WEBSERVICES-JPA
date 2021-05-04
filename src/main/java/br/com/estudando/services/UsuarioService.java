package br.com.estudando.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.estudando.entidades.Usuario;
import br.com.estudando.repositorys.UsuarioRepository;
import br.com.estudando.services.exception.DatabaseConstraintException;
import br.com.estudando.services.exception.RegistroNaoEncontradoException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario encontrarUsuarioPorId(Long id) {
		Optional<Usuario> usuarioEncontrario = usuarioRepository.findById(id);
		return usuarioEncontrario.orElseThrow(() -> new RegistroNaoEncontradoException(id));

	}

	public Usuario criarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void deletarUsuario(Long id) {
		try {
			usuarioRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RegistroNaoEncontradoException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseConstraintException(e.getMessage());
		}
	}

	public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
		try {
			Usuario usuario = usuarioRepository.getOne(id);
			atualizarUsuario(usuario, usuarioAtualizado);
			return usuarioRepository.save(usuario);
		} catch (EntityNotFoundException e) {
			throw new RegistroNaoEncontradoException(id);
		}

	}

	private void atualizarUsuario(Usuario usuario, Usuario usuarioAtualizado) {
		usuario.setNome(usuarioAtualizado.getNome());
		usuario.setEmail(usuarioAtualizado.getEmail());
		usuario.setTelefone(usuarioAtualizado.getTelefone());
		usuario.setSenha(usuarioAtualizado.getSenha());

	}

}
