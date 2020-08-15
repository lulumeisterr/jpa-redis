package br.com.fiap.persistence.bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author lucasrodriguesdonascimento 
 * 
 * Classe de endereco , utilizando o Embeddable para atribuir um endereco ao cliente
 * A chave-primária não pode ser mantida pela classe embutida e sim na classe que contém ela
 */


@Embeddable
public class Endereco {

	@Column(name = "nm_logradouro", nullable = false)
	private String logradouro;

	@Column(name = "numero", nullable = false)
	private String numero;

	public Endereco() {
		
	}
	
	public Endereco(String logradouro, String numero) {
		this.logradouro = logradouro;
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}
