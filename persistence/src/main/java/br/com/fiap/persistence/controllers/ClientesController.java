package br.com.fiap.persistence.controllers;

import br.com.fiap.persistence.models.Cliente;
import br.com.fiap.persistence.presenters.ClientePresenter;
import br.com.fiap.persistence.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(value = "/clientes")
public class ClientesController {

	@Autowired
	ClienteService clienteService;

	@GetMapping()
	public ResponseEntity<List<ClientePresenter>> getAll() {
		List<ClientePresenter> lista = clienteService.findAll().stream().map(ClientePresenter::new).collect(toList());
		return new ResponseEntity<List<ClientePresenter>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ClientePresenter> getbyId(@PathVariable Long codigo){
		Optional<Cliente> cliente = clienteService.findById(codigo);
		if(cliente.isPresent())
			return ResponseEntity.ok(new ClientePresenter(cliente.get()));
		else
			return ResponseEntity.notFound().build();
	}

	@PostMapping()
	public ResponseEntity<ClientePresenter> add(@RequestBody ClientePresenter cliente, UriComponentsBuilder builder) {
		cliente.setCodigo(null);
		Cliente savedProduto = clienteService.add(cliente.toModel());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/clientes/{id}").buildAndExpand(savedProduto.getCodigo()).toUri());
		return new ResponseEntity<ClientePresenter>(new ClientePresenter(savedProduto), headers, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<ClientePresenter> update(@RequestBody ClientePresenter cliente) {
		ClientePresenter c = new ClientePresenter(clienteService.update(cliente.toModel()));
		return new ResponseEntity<ClientePresenter>(c, HttpStatus.OK);
	}
		
	@DeleteMapping("/{codigo}")
	public void deleteById(@PathVariable Long codigo) {
		clienteService.deleteById(codigo);
	}

}
