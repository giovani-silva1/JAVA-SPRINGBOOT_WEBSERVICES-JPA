package br.com.estudando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudando.entidades.Pedido;
import br.com.estudando.repositorys.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> listarTodos() {
		List<Pedido> pedidosEncontrados = pedidoRepository.findAll();
		return pedidosEncontrados;
	}

	public Pedido TrazerPedidoPorId(Long id) {
		Optional<Pedido> pedidoEncontrado = pedidoRepository.findById(id);
		return pedidoEncontrado.get();
	}
}
