package br.com.fiap.persistence.presenters;

import br.com.fiap.persistence.models.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class ClientePresenter implements Serializable {
    private Long id;
    private String nome;
    private EnderecoPresenter endereco;


    public ClientePresenter(Cliente cliente) {
        this.id = cliente.getCodigo();
        this.nome = cliente.getNome();
        this.endereco = new EnderecoPresenter(cliente.getEndereco());
    }


}
