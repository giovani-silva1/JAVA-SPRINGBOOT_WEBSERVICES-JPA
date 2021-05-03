package br.com.estudando;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.estudando.entidades.Pedido;
import br.com.estudando.entidades.Usuario;
import br.com.estudando.entidades.enums.StatusPedido;
import br.com.estudando.repositorys.PedidoRepository;
import br.com.estudando.repositorys.UsuarioRepository;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

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

	}

}
