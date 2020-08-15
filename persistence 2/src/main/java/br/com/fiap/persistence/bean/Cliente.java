package br.com.fiap.persistence.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Embedded é utilizada para marcar campos ou métodos getter nas entidades que
 *           referencia a entidade embutida.
 * 
 * @author lucasrodriguesdonascimento
 *
 */

@Entity
@Table(name = "T_CLIENTE")
@SequenceGenerator(name = "cliente", allocationSize = 1, sequenceName = "SQ_T_CLIENTE")
@Getter
@Setter
@AllArgsConstructor
public class Cliente implements Serializable {

	private static final long serialVersionUID = -9041949238978234030L;

	@Id
	@GeneratedValue(generator = "cliente", strategy = GenerationType.AUTO)
	@Column(name = "cd_cliente")
	private Integer cliente;

	@Column(name = "nm_cliente", nullable = false, length = 255)
	private String nome;

	@Embedded
	private Endereco endereco;

	@ManyToOne(cascade = CascadeType.ALL)
	private Pedido clientePedido;

	public Cliente(String nome, Endereco endereco) {
		super();

		this.nome = nome;
		this.endereco = endereco;
	}
	

	public Cliente(String nome, Endereco endereco, Pedido pedido) {
		super();
		
		this.nome = nome;
		this.endereco = endereco;
		this.clientePedido = pedido;
	}


	public Cliente() {

	}
}
