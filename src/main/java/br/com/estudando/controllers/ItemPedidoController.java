package br.com.estudando.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudando.entidades.ItemPedido;
import br.com.estudando.services.ItemPedidoService;

@RestController
@RequestMapping(value = "/itens")
public class ItemPedidoController {

	@Autowired
	private ItemPedidoService itemPedidoService;

	@GetMapping
	public ResponseEntity<List<ItemPedido>> listarTodos() {
		return ResponseEntity.ok().body(itemPedidoService.listarItens());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ItemPedido> encontrarItemPedidoPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(itemPedidoService.itemById(id));
	}

}
