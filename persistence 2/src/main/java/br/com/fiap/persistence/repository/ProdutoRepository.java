package br.com.fiap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.persistence.bean.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
