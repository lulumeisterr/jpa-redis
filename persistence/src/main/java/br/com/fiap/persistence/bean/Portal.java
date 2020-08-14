package br.com.fiap.persistence.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * O portal possui vários produtos em estoque e com uma determinada quantidade
 * em estoque de cada um desses produtos.
 * 
 * @author lucasrodriguesdonascimento
 *
 */
@Entity
@Table(name = "T_PORTAL")
@SequenceGenerator(name = "portal", sequenceName = "T_PORTAL", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
public class Portal {

	@Id
	@GeneratedValue(generator = "portal", strategy = GenerationType.AUTO)
	private int codigo;
	@Column(name = "ds_nome", nullable = false)
	private String nome;

	@ManyToMany(mappedBy = "listaPortalProdutoEstoque")
	List<ProdutoEstoque> listaProdutosEstoque = new ArrayList<ProdutoEstoque>();

	public Portal() {

	}

	public Portal(String nome) {
		super();
		this.nome = nome;
	}

	public Portal(List<ProdutoEstoque> listaProdutosEstoque) {
		super();
		this.listaProdutosEstoque = listaProdutosEstoque;
	}

	public Portal(String nome, List<ProdutoEstoque> listaProdutosEstoque) {
		super();

		this.nome = nome;
		this.listaProdutosEstoque = listaProdutosEstoque;
	}

}
