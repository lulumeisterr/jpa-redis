package br.com.fiap.persistence.controllers;

import br.com.fiap.persistence.models.Cliente;
import br.com.fiap.persistence.presenters.ClientePresenter;
import br.com.fiap.persistence.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(value = "clientes")
public class ClientesController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClientePresenter>> getAll(){
        return ResponseEntity.ok(clienteService.findAll().stream().map(ClientePresenter::new).collect(toList()));
    }

    @GetMapping("{codigo}")
    public ResponseEntity<ClientePresenter> getbyId(@PathVariable Long codigo){
        Optional<Cliente> cliente = clienteService.findById(codigo);
        if(cliente.isPresent())
            return ResponseEntity.ok(new ClientePresenter(cliente.get()));
        else
            return ResponseEntity.notFound().build();
    }

}
