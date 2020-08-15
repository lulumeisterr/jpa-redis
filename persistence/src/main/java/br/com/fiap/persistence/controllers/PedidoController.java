package br.com.fiap.persistence.controllers;



import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.persistence.models.Pedido;
import br.com.fiap.persistence.presenters.PedidoPresenter;
import br.com.fiap.persistence.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<PedidoPresenter>> getAll(){
		return ResponseEntity.ok(pedidoService.findAll().stream().map(PedidoPresenter::new).collect(toList()));
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<PedidoPresenter> getById(@PathVariable Long codigo){
		Optional<Pedido> pedido = pedidoService.findById(codigo);
		if(pedido.isPresent()) {
			return ResponseEntity.ok(new PedidoPresenter(pedido.get()));
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public void add(@RequestBody PedidoPresenter pedido){
		pedidoService.add(pedido);
	}
	
	@PostMapping("/listaPedidos")
	public void addAll(@RequestBody List<PedidoPresenter> pedidos) {
		pedidoService.addAll(pedidos);
	}
	
	@DeleteMapping("/{codigo}")
	public void deleteById(@PathVariable Long codigo) {
		pedidoService.deleteById(codigo);
	}
	
	
	
	
	
	

}
