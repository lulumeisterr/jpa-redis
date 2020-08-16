package br.com.fiap.persistence.presenters;

import br.com.fiap.persistence.models.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class ProdutoPresenter implements Serializable {
	
	private Long codigo;
	
	private String nome;
	
	private Integer quantidade;
	
	private Double valor;
	
	public ProdutoPresenter(Produto produto) {
		if(produto!=null) {
			this.codigo = produto.getCodigo();
			this.nome = produto.getNome();
			this.quantidade = produto.getQuantidade();
			this.valor = produto.getValor();
		}
	}
	
	public Produto toModel(){
		Produto produto = new Produto(){{
			setCodigo(this.getCodigo());
			setNome(this.getNome());
			setQuantidade(this.getQuantidade());
			setValor(this.getValor());
		}};
		return produto;
	}

}
