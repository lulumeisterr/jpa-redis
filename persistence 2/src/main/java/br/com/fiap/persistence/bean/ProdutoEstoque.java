package br.com.fiap.persistence.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "T_PRODUTO_ESTOQUE")
@SequenceGenerator(name = "produtoEstoque", sequenceName = "T_PRODUTO_ESTOQUE", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
public class ProdutoEstoque {

	@Id
	@GeneratedValue(generator = "produtoEstoque", strategy = GenerationType.AUTO)
	@Column(name = "cd_produto_estoque")
	private Integer produtoEstoque;

	@Column(name = "ds_produto", nullable = false)
	private String descricao;

	// JoinColumn Nome da tabela associativa
	// JoinTable - Nome da tabela associativa
	// joinColumns Vira chave estrangeira da propria entidade , chave primaria da
	// outra associativa
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "T_PORTAL_PRODUTO_ESTOQUE", joinColumns = @JoinColumn(name = "cd_produto_estoque"), inverseJoinColumns = @JoinColumn(name = "cd_portal"))
	List<Portal> listaPortalProdutoEstoque;

	public ProdutoEstoque(String descricao, List<Portal> listaPortalProdutoEstoque) {
		super();
		this.descricao = descricao;
		this.listaPortalProdutoEstoque = listaPortalProdutoEstoque;
	}

	public ProdutoEstoque() {

	}

}
