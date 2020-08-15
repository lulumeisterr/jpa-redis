package br.com.fiap.persistence.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Cada pedido possuis um ou mais produtos
 * 
 * @author lucasrodriguesdonascimento
 *
 */
@Entity
@Table(name = "T_PEDIDO")
@SequenceGenerator(name = "pedido", sequenceName = "SQ_T_PEDIDO", allocationSize = 1)
public class Pedido {

	@Id
	@GeneratedValue(generator = "pedido", strategy = GenerationType.IDENTITY)
	@Column(name = "cd_pedido")
	private Long codigo;

	@Column(name = "ds_pedido", nullable = false, length = 255)
	private String descricao;

	@Column(name = "dt_pedido", nullable = false)
	private LocalDateTime data;

	/**
	 * mappedBy, você torna o relacionamento bidiricional, 
	 * onde os dois lados do relacionaomento se convesam
	 * 
	 * orphanRemoval -> Se voce deletar um Pedido ele vai deletar os produtos
	 * Cascade -> Vai realizar a acao para todo o relacionamento
	 */
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, targetEntity = Produto.class, orphanRemoval = false, cascade = CascadeType.REFRESH)
	private List<Produto> produtos;

	/**
	 * E varios pedidos pode pertencer a um ou mais cliente
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private Cliente pedidoCliente;

	public Pedido() {

	}
	
	public Pedido(String descricao, LocalDateTime data, List<Produto> produtos, Cliente pedidoCliente) {
		super();

		this.descricao = descricao;
		this.data = data;
		this.produtos = produtos;
		this.pedidoCliente = pedidoCliente;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Cliente getPedidoCliente() {
		return pedidoCliente;
	}
	public void setPedidoCliente(Cliente pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}



}
