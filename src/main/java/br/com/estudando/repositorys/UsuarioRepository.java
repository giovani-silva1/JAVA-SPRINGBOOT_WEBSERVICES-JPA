package br.com.estudando.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estudando.entidades.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario,Long>{

	
}
