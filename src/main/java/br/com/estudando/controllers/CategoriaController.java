package br.com.estudando.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudando.entidades.Categoria;
import br.com.estudando.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<Categoria>> listarTodas() {
		return ResponseEntity.ok().body(categoriaService.listarCategorias());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> listarCategoriaPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(categoriaService.encontrarCategoriaPorId(id));
	}

}
