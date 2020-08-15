package br.com.fiap.persistence.services;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.persistence.models.Produto;
import br.com.fiap.persistence.repository.ProdutoRepository;

@Component
public class ProdutoService {
	
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public void add(Produto produto) {
        produtoRepository.save(produto);
    }

    @Transactional()
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Transactional
    public void addAll(Collection<Produto> produtos) {
        for (Produto produto : produtos) {
            produtoRepository.save(produto);
        }
    }

}
