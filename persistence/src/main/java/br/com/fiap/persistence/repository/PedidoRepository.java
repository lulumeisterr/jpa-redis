package br.com.fiap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.persistence.bean.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
