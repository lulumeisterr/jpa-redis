package br.com.fiap.persistence.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import br.com.fiap.persistence.models.Pedido;
import br.com.fiap.persistence.presenters.PedidoPresenter;
import br.com.fiap.persistence.repository.PedidoRepository;

@Component
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    @Caching(
            put= { @CachePut(value= "pedidoBase", key= "#pedidoBase.codigo") },
            evict = { @CacheEvict(value= "allPedidos", allEntries= true) }
    )
    public void add(PedidoPresenter pedido) {
    	Pedido pedidoBase = pedido.toModel();
    	pedidoRepository.save(pedidoBase);
    }

    @Cacheable(value= "allPedidos", unless= "#result.size() == 0")
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Transactional
    @CacheEvict(value= "allPedidos", allEntries= true)
    public void addAll(Collection<PedidoPresenter> pedidos) {
        pedidos.stream().map(PedidoPresenter::toModel).forEach(pedidoRepository::save);
    }
    
    @Cacheable(value= "pedido", key = "#codigo")
    public Optional<Pedido> findById(Long codigo) {
    	return pedidoRepository.findById(codigo);
    }
    
    @Caching(evict= {
        @CacheEvict(value= "pedido", key= "#codigo"),
        @CacheEvict(value= "allPedidos", allEntries= true)
    })
    public void deleteById(Long codigo) {
    	pedidoRepository.deleteById(codigo);
    }

}
