package br.com.estudando.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudando.entidades.Produto;
import br.com.estudando.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<Produto>> listarTodos() {
		return ResponseEntity.ok().body(produtoService.listarTodos());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> listarProdutoPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(produtoService.listarProdutoPorId(id));
	}

}
