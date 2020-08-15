package br.com.fiap.persistence.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.persistence.models.Produto;
import br.com.fiap.persistence.presenters.ProdutoPresenter;
import br.com.fiap.persistence.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@PostMapping("/produto")
	public ResponseEntity<Void> addProduto(@RequestBody Produto produto, UriComponentsBuilder builder) {
		Produto savedProduto = produtoService.add(produto);  
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/produto/{id}").buildAndExpand(savedProduto.getCodigo()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/listarProduto")
	public ResponseEntity<List<Produto>> getAllProdutos() {
		List<Produto> lista = produtoService.findAll();
		return new ResponseEntity<List<Produto>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<ProdutoPresenter> getById(@PathVariable Long codigo){
		Optional<Produto> produto = produtoService.findById(codigo);
		if(produto.isPresent()) {
			return ResponseEntity.ok(new ProdutoPresenter(produto.get()));
		}else {
			return ResponseEntity.notFound().build();
		}
	}


}
