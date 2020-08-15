package br.com.fiap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.persistence.bean.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
