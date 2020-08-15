package br.com.fiap.persistence.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import br.com.fiap.persistence.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import br.com.fiap.persistence.models.Pedido;
import br.com.fiap.persistence.repository.PedidoRepository;

@Component
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    @Caching(
            put= { @CachePut(value= "pedido", key= "#pedido.codigo") },
            evict = { @CacheEvict(value= "allPedidos", allEntries= true) }
    )
    public Pedido add(Pedido pedido) {
    	return pedidoRepository.save(pedido);
    }

    @Cacheable(value= "allPedidos", unless= "#result.size() == 0")
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Transactional
    @CacheEvict(value= "allPedidos", allEntries= true)
    public void addAll(Collection<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
        	pedidoRepository.save(pedido);
        }
    }

    @Caching(evict= {
        @CacheEvict(value= "pedido", key= "#codigo"),
        @CacheEvict(value= "allPedidos", allEntries= true)
    })
    public void delete(long id){ pedidoRepository.deleteById(id); }

    @CacheEvict(value= "pedido", allEntries= true)
    public void deleteAll(){
        pedidoRepository.deleteAll();
    }

    @Cacheable(value= "pedido", key = "#codigo")
    public Optional<Pedido> findById(Long codigo){
        return pedidoRepository.findById(codigo);
    }

}
