package br.com.estudando;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.estudando.entidades.Usuario;
import br.com.estudando.repositorys.UsuarioRepository;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {

		Usuario a1 = new Usuario(null, "Carlos Almeida", "carlos@email.com", "11 96633-7839", "1234");
		Usuario a2 = new Usuario(null, "Fabio Torres", "fabio@email.com", "11 96633-7840", "1336");

		usuarioRepository.saveAll(Arrays.asList(a1, a2));

	}

}
