package br.com.fiap.persistence.services;

import br.com.fiap.persistence.models.Cliente;
import br.com.fiap.persistence.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    @Caching(
            put= { @CachePut(value= "cliente", key= "#cliente.codigo") },
            evict = { @CacheEvict(value= "allClientes", allEntries= true) }
    )
    public Cliente add(Cliente cliente) { 
    	return clienteRepository.save(cliente); 
    	}

    @Cacheable(value= "allClientes", unless= "#result.size() == 0")
    public List<Cliente> findAll() { return clienteRepository.findAll(); }

    @Transactional
    @CacheEvict(value= "allClientes", allEntries= true)
    public void addAll(Collection<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            clienteRepository.save(cliente);
        }
    }

    @Caching(evict= {
            @CacheEvict(value= "cliente", key= "#codigo"),
            @CacheEvict(value= "allClientes", allEntries= true)
        })
    public void deleteById(Long codigo) {
    	clienteRepository.deleteById(codigo);
    }

    @CacheEvict(value= "cliente", allEntries= true)
    public void deleteAll(){
        clienteRepository.deleteAll();
    }

    @Cacheable(value= "cliente", key = "#codigo")
    public Optional<Cliente> findById(Long codigo){
        return clienteRepository.findById(codigo);
    }
}
