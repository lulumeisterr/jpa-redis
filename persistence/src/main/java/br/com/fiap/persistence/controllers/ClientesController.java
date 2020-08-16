package br.com.fiap.persistence.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.persistence.models.Cliente;
import br.com.fiap.persistence.presenters.ClientePresenter;
import br.com.fiap.persistence.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClientesController {

	@Autowired
	ClienteService clienteService;

	@PostMapping("/cliente")
	public ResponseEntity<Void> addCliente(@RequestBody Cliente cliente, UriComponentsBuilder builder) {
	
		Cliente savedProduto = clienteService.add(cliente);  
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/clientes/{id}").buildAndExpand(savedProduto.getCodigo()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Cliente>> getAllProdutos() {
		List<Cliente> lista = clienteService.findAll();
		return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ClientePresenter> getbyId(@PathVariable Long codigo){
		Optional<Cliente> cliente = clienteService.findById(codigo);
		if(cliente.isPresent())
			return ResponseEntity.ok(new ClientePresenter(cliente.get()));
		else
			return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/cliente")
	public ResponseEntity<Cliente> updateProduto(@RequestBody Cliente cliente) {
		clienteService.update(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
		
	@DeleteMapping("/{codigo}")
	public void deleteById(@PathVariable Long codigo) {
		clienteService.deleteById(codigo);
	}

}
