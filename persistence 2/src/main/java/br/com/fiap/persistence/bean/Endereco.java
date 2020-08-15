package br.com.fiap.persistence.bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author lucasrodriguesdonascimento a chave-primária não pode ser mantida pela
 *         classe embutida e sim na classe que contém ela
 */


@Embeddable
@Getter
@Setter
@AllArgsConstructor
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

}
