package br.com.fiap.persistence.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Cada pedido possui um ou mais produtos
 * 
 * @author lucasrodriguesdonascimento
 *
 */
@Entity
@Table(name = "T_PEDIDO")
@SequenceGenerator(name = "pedido", sequenceName = "SQ_T_PEDIDO", allocationSize = 1)
@Getter @Setter @AllArgsConstructor
public class Pedido {

	@Id
	@GeneratedValue(generator = "pedido", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_pedido")
	private int codigo;

	@Column(name = "ds_pedido", nullable = false, length = 255)
	private String descricao;

	@Column(name = "dt_pedido", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;

	/**
	 * MappedBy para enxergar o atributo da classe Produto Lista de Produto esta
	 * mapeado para Produto
	 * 
	 * orphanRemoval -> Se voce deletar um Pedido ele vai deletar os produtos
	 * Cascade -> Vai realizar a acao para todo o relacionamento
	 */
	@OneToMany(mappedBy = "pedido",targetEntity = Produto.class, orphanRemoval = true , cascade = javax.persistence.CascadeType.ALL)
	private List<Produto> produto = new ArrayList<Produto>();

	/**
	 * E um cliente esta associado a um ou mais pedidos.
	 */

	@OneToMany(mappedBy = "cliente", cascade = javax.persistence.CascadeType.ALL)	
	private List<Cliente> clientePedido;

	public Pedido() {
		
	}
	
	public Pedido(String descricao, Calendar data) {
		super();
		this.descricao = descricao;
		this.data = data;
	}

	public Pedido(String descricao, GregorianCalendar data, List<Produto> produto, List<Cliente> cliente) {
		super();
		this.descricao = descricao;
		this.data = data;
		this.produto = produto;
		this.clientePedido = cliente;
	}
	

}
