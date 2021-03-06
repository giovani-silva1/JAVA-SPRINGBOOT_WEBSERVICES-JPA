package br.com.estudando;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.estudando.entidades.Categoria;
import br.com.estudando.entidades.ItemPedido;
import br.com.estudando.entidades.Pagamento;
import br.com.estudando.entidades.Pedido;
import br.com.estudando.entidades.Produto;
import br.com.estudando.entidades.Usuario;
import br.com.estudando.entidades.enums.StatusPedido;
import br.com.estudando.repositorys.CategoriaRepository;
import br.com.estudando.repositorys.ItemPedidoRepository;
import br.com.estudando.repositorys.PedidoRepository;
import br.com.estudando.repositorys.ProdutoRepository;
import br.com.estudando.repositorys.UsuarioRepository;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ItemPedidoRepository ItemPedidoRepository;

	@Override
	public void run(String... args) throws Exception {

		Usuario a1 = new Usuario(null, "Carlos Almeida", "carlos@email.com", "11 96633-7839", "1234");
		Usuario a2 = new Usuario(null, "Fabio Torres", "fabio@email.com", "11 96633-7840", "1336");

		usuarioRepository.saveAll(Arrays.asList(a1, a2));

		Pedido p1 = new Pedido(null, Instant.parse("2018-11-30T18:35:24.00Z"), StatusPedido.ENTREGUE, a2);
		Pedido p2 = new Pedido(null, Instant.parse("2016-11-30T18:40:24.00Z"), StatusPedido.CANCELADO, a2);
		Pedido p3 = new Pedido(null, Instant.parse("2014-09-30T18:40:24.00Z"), StatusPedido.ENVIADO, a1);
		Pedido p4 = new Pedido(null, Instant.parse("2014-05-30T18:40:24.00Z"), StatusPedido.PAGO, a1);

		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

		Categoria categoria = new Categoria(null, "Eletronicos");
		Categoria categoria2 = new Categoria(null, "Livros");
		Categoria categoria3 = new Categoria(null, "Computador");

		Produto produto = new Produto(null, "PC GAMER", "PC GAMER DELL LATITUDE 4400", 6500.00, "");
		Produto produto1 = new Produto(null, "LIVRO HARRY POTTER", "LIVRO DO HARRY POTTER ESCRITORA XXX", 900.00, "");
		Produto produto2 = new Produto(null, "LIVRO MARLEY E EU", "LIVRO DE UM ROMANCE ENTRE HUMANO E CACHORRO", 500.00,
				"");
		Produto produto3 = new Produto(null, "NOTEBOOK", "NOTEBOOK ACER", 8500.00, "");
		Produto produto4 = new Produto(null, "MOUSE ", "MOUSE DA MARCA RAZER", 2500.00, "");
		Produto produto5 = new Produto(null, "SMARTTV ", "SMART TV SAMSUNG ", 2500.00, "");

		categoriaRepository.saveAll(Arrays.asList(categoria, categoria2, categoria3));
		produtoRepository.saveAll(Arrays.asList(produto, produto1, produto2, produto3, produto4, produto5));

		// adicionando categorias em produtos.
		produto.getCategorias().add(categoria);
		produto.getCategorias().add(categoria3);

		produto1.getCategorias().add(categoria2);
		produto2.getCategorias().add(categoria2);
		produto3.getCategorias().add(categoria);
		produto3.getCategorias().add(categoria3);
		produto4.getCategorias().add(categoria);
		produto4.getCategorias().add(categoria3);
		produto5.getCategorias().add(categoria3);

		produtoRepository.saveAll(Arrays.asList(produto, produto1, produto2, produto3, produto4, produto5));

		ItemPedido item1 = new ItemPedido(p4, produto5, 2, 5000.00);
		ItemPedido item2 = new ItemPedido(p4, produto1, 1, 2000.00);
		ItemPedido item3 = new ItemPedido(p1, produto2, 1, 200.00);
		ItemPedido item4 = new ItemPedido(p1, produto3, 10, 50.00);
		ItemPedido item5 = new ItemPedido(p2, produto1, 1, 2000.00);
		ItemPedido item6 = new ItemPedido(p3, produto5, 3, 4000.00);

		ItemPedidoRepository.saveAll(Arrays.asList(item1, item2, item3, item4, item5, item6));

		
		Pagamento pag1 = new Pagamento(null,Instant.parse("2018-11-30T20:35:24.00Z") , p1);
		p1.setPagamento(pag1);
		pedidoRepository.save(p1);
	}

}
