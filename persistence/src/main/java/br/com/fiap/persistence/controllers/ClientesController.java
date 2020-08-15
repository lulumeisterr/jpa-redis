package br.com.fiap.persistence.controllers;

import br.com.fiap.persistence.presenters.ClientePresenter;
import br.com.fiap.persistence.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(value = "clientes")
public class ClientesController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public List<ClientePresenter> getAll(){
        return clienteService.findAll().stream().map(ClientePresenter::new).collect(toList());
    }

}
