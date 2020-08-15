package br.com.fiap.persistence.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.persistence.models.Cliente;
import br.com.fiap.persistence.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteService {
	
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public void add(Cliente cliente) {
    	clienteRepository.save(cliente);
    public Cliente add(Cliente cliente) {
    	return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public void deleteAll(){
        clienteRepository.deleteAll();
    }
    public Optional<Cliente> findById(Long clienteId){
        return clienteRepository.findById(clienteId);
    public Optional<Cliente> findById(Long codigo){
        return clienteRepository.findById(codigo);
