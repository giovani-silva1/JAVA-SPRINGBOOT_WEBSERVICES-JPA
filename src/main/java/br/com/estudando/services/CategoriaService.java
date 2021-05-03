package br.com.estudando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudando.entidades.Categoria;
import br.com.estudando.repositorys.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> listarCategorias() {
		return categoriaRepository.findAll();
	}

	public Categoria encontrarCategoriaPorId(Long id) {
		Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(id);
		return categoriaEncontrada.get();
	}

}
