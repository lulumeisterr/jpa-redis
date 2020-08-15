package br.com.fiap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.persistence.bean.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
