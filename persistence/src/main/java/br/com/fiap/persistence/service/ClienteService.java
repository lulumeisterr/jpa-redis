package br.com.fiap.persistence.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.persistence.bean.Cliente;
import br.com.fiap.persistence.repository.ClienteRepository;

@Component
public class ClienteService {
	
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public void add(Cliente cliente) {
    	clienteRepository.save(cliente);
    }
}
