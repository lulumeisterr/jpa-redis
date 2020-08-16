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

import br.com.fiap.persistence.models.Produto;
import br.com.fiap.persistence.presenters.ProdutoPresenter;
import br.com.fiap.persistence.services.ProdutoService;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@GetMapping()
	public ResponseEntity<List<ProdutoPresenter>> getAll() {
		List<ProdutoPresenter> lista = produtoService.findAll().stream().map(ProdutoPresenter::new).collect(toList());
		return new ResponseEntity<List<ProdutoPresenter>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<ProdutoPresenter> getById(@PathVariable Long codigo){
		Optional<Produto> produto = produtoService.findById(codigo);
		if(produto.isPresent()) {
			return ResponseEntity.ok(new ProdutoPresenter(produto.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{codigo}")
	public void deleteById(@PathVariable Long codigo) {
		produtoService.deleteById(codigo);
	}

	@PostMapping()
	public ResponseEntity<ProdutoPresenter> add(@RequestBody ProdutoPresenter produto, UriComponentsBuilder builder) {
		produto.setCodigo(null);
		Produto savedProduto = produtoService.add(produto.toModel());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/produto/{id}").buildAndExpand(savedProduto.getCodigo()).toUri());
		return new ResponseEntity<ProdutoPresenter>(new ProdutoPresenter(savedProduto), headers, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<ProdutoPresenter> update(@RequestBody ProdutoPresenter produto) {
		ProdutoPresenter p = new ProdutoPresenter( produtoService.update(produto.toModel()) );
		return new ResponseEntity<ProdutoPresenter>(p, HttpStatus.OK);
	}

}
