package br.com.fiap.persistence.presenters;

import br.com.fiap.persistence.models.Endereco;

import java.io.Serializable;

public class EnderecoPresenter implements Serializable {
    private String logradouro;
    private String numero;

    public EnderecoPresenter(){}

    public EnderecoPresenter(Endereco endereco) {
        this.logradouro = endereco.getLogradouro();
        this.numero = endereco.getNumero();
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }
}
