package br.com.fiap.persistence.presenters;

import br.com.fiap.persistence.models.Cliente;

import java.io.Serializable;

public class ClientePresenter implements Serializable {
    private Integer id;
    private String nome;
    private EnderecoPresenter endereco;

    public ClientePresenter(){}

    public ClientePresenter(Cliente cliente) {
        this.id = cliente.getCodigo();
        this.nome = cliente.getNome();
        this.endereco = new EnderecoPresenter(cliente.getEndereco());
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public EnderecoPresenter getEndereco() {
        return endereco;
    }

}
