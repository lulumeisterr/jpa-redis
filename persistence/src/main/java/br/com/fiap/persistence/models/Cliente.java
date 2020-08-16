package br.com.fiap.persistence.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

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
public class Cliente implements Serializable {

	private static final long serialVersionUID = -9041949238978234030L;

	@Id
	@GeneratedValue(generator = "cliente", strategy = GenerationType.IDENTITY)
	@Column(name = "cd_cliente")
	private Long codigo;

	@Column(name = "nm_cliente", nullable = false, length = 255)
	private String nome;

	@Embedded
	private Endereco endereco;

	/**
	 * Um cliente esta associado um ou varios pedidos
	 */
	@OneToMany(mappedBy = "pedidoCliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Pedido> pedidos;

	public Cliente(String nome, Endereco endereco) {
		super();

		this.nome = nome;
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"codigo=" + codigo +
				", nome='" + nome + '\'' +
				'}';
	}

	public Cliente(String nome, Endereco endereco, List<Pedido> pedidos) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.pedidos = pedidos;
	}

	public Cliente() {

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


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public List<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
}
