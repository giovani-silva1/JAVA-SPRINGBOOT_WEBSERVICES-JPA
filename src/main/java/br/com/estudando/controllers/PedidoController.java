package br.com.estudando.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudando.entidades.Pedido;
import br.com.estudando.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<Pedido>> listarTodos() {
		return ResponseEntity.ok().body(pedidoService.listarTodos());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> trazerPedidoPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(pedidoService.TrazerPedidoPorId(id));
	}
}
