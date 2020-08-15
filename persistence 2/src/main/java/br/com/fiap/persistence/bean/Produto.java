package br.com.fiap.persistence.bean;

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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Um produto pode aparecer em um ou mais pedidos.
 * 
 * @author lucasrodriguesdonascimento
 *
 */
@Entity
@Table(name = "T_PRODUTO")
@SequenceGenerator(name = "produto", allocationSize = 1, sequenceName = "SQ_PRODUTO")
@Getter
@Setter
@AllArgsConstructor
public class Produto implements Serializable {

	private static final long serialVersionUID = 8126784570860373046L;

	@Id
	@Column(name = "cd_produto")
	@GeneratedValue(generator = "produto", strategy = GenerationType.AUTO)
	private Integer codigo;

	@Column(name = "nm_produto", nullable = false, length = 100)
	private String nome;

	@Column(name = "qtd_produto", nullable = false)
	private Integer quantidade;

	@Column(name = "vl_produto", nullable = false)
	private Double valor;

	/**
	 * noemanto da coluna que possui a chave-estrangeira requerida pela associação
	 * 
	 * @author lucasrodriguesdonascimento
	 */
	@ManyToOne(cascade=CascadeType.PERSIST)
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

}
