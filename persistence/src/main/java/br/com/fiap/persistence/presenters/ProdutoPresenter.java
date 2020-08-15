package br.com.fiap.persistence.presenters;

import java.io.Serializable;

import br.com.fiap.persistence.models.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProdutoPresenter implements Serializable {
	
	private Long codigo;
	
	private String nome;
	
	private Integer quantidade;
	
	private Double valor;
	
	public ProdutoPresenter(Produto produto) {
		this.codigo = produto.getCodigo();
		this.nome = produto.getNome();
		this.quantidade = produto.getQuantidade();
		this.valor = produto.getValor();
	}
	
	

}
