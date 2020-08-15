package br.com.fiap.persistence.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import br.com.fiap.persistence.models.Produto;
import br.com.fiap.persistence.repository.ProdutoRepository;

@Component
public class ProdutoService {
	
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    @Caching(
            put= { @CachePut(value= "produto", key= "#produto.codigo") },
            evict = { @CacheEvict(value= "allProdutos", allEntries= true) }
    )
    public Produto add(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Cacheable(value= "allProdutos", unless= "#result.size() == 0")
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Transactional
    @CacheEvict(value= "allProdutos", allEntries= true)
    public void addAll(Collection<Produto> produtos) {
        for (Produto produto : produtos) {
            produtoRepository.save(produto);
        }
    }

    @Caching(evict= {
        @CacheEvict(value= "produto", key= "#codigo"),
        @CacheEvict(value= "allProdutos", allEntries= true)
    })
    public void delete(long id){
        produtoRepository.deleteById(id);
    }

    @CacheEvict(value= "produto", allEntries= true)
    public void deleteAll(){
        produtoRepository.deleteAll();
    }
    
    @Caching(evict= {
            @CacheEvict(value= "produto", key= "#codigo"),
            @CacheEvict(value= "allProdutos", allEntries= true)
        })
    public void deleteById(Long codigo) {
    	produtoRepository.deleteById(codigo);
    }

    @Cacheable(value= "produto", key = "#codigo")
    public Optional<Produto> findById(Long codigo){
        return produtoRepository.findById(codigo);
    }

}
