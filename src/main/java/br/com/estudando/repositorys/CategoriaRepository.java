package br.com.estudando.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estudando.entidades.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

}
