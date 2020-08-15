package br.com.fiap.persistence.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Um produto pode aparecer em um ou mais pedidos.
 * 
 * @author lucasrodriguesdonascimento
 *
 */
@Entity
@Table(name = "T_PRODUTO")
@SequenceGenerator(name = "produto", allocationSize = 1, sequenceName = "SQ_PRODUTO")
public class Produto implements Serializable {

	private static final long serialVersionUID = 8126784570860373046L;

	@Id
	@Column(name = "cd_produto")
	@GeneratedValue(generator = "produto", strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "nm_produto", nullable = false, length = 100)
	private String nome;

	@Column(name = "qtd_produto", nullable = false)
	private Integer quantidade;

	@Column(name = "vl_produto", nullable = false)
	private Double valor;

	/**
	 * noemanto da coluna que possui a chave-estrangeira requerida pela associação
	 * 
	 * Um produto pode aparecer em um ou mais pedidos. 
	 * 
	 * @author lucasrodriguesdonascimento
	 */
	@ManyToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "pedido")
	private Pedido pedido;
	
	public Produto() {
		
	}
	
	public Produto(String nome, Integer quantidade, Double valor) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;

	}
	
	public Produto(String nome, Integer quantidade, Double valor, Pedido pedido) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		this.pedido = pedido;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
