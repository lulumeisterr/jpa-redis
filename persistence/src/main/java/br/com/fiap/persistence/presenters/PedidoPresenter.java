package br.com.fiap.persistence.presenters;

import java.io.Serializable;


public class PedidoPresenter implements Serializable {
	
	private Long codigo;
	
	private String descricao;
	
	private String data;
	
	public PedidoPresenter() {};
	
	public PedidoPresenter(Long codigo, String descricao, String data) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.data = data;
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


	
	
	

}
