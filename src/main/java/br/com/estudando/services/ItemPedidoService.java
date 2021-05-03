package br.com.estudando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudando.entidades.ItemPedido;
import br.com.estudando.repositorys.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public List<ItemPedido> listarItens(){
		return itemPedidoRepository.findAll();
	}
	
	public ItemPedido itemById(Long id) {
		Optional<ItemPedido> itemEncontrado = itemPedidoRepository.findById(id);
		return itemEncontrado.get();
	}
}
