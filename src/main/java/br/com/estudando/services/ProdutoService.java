package br.com.estudando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudando.entidades.Produto;
import br.com.estudando.repositorys.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public List<Produto> listarTodos(){
		return produtoRepository.findAll();
	}
	
	
	public Produto listarProdutoPorId(Long id) {
		Optional<Produto>produtoEncontrado = produtoRepository.findById(id);
		return produtoEncontrado.get();
	}
	
}
