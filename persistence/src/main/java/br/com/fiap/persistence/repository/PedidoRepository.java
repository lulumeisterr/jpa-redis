package br.com.fiap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.persistence.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
