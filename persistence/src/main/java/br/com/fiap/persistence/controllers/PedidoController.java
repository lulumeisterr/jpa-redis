package br.com.fiap.persistence.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.persistence.models.Pedido;
import br.com.fiap.persistence.services.PedidoService;

@RestController
@RequestMapping("pedidos")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping
	public List<Pedido> getAll(){
		return pedidoService.findAll();
	}

}
