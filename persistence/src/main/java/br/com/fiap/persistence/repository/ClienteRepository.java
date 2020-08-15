package br.com.fiap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.persistence.bean.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
