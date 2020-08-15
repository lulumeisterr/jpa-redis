package br.com.fiap.persistence.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.persistence.models.Produto;
import br.com.fiap.persistence.services.ProdutoService;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> getAll(){
		return produtoService.findAll();
	}
	
	@PostMapping
	public void add(Produto produto) {
		produtoService.add(produto);
	}
	
	@PostMapping
	public void addAll(List<Produto> produtos) {
		produtoService.addAll(produtos);
	}

}
