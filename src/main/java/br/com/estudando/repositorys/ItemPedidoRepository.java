package br.com.estudando.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estudando.entidades.ItemPedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido,Long> {

}
