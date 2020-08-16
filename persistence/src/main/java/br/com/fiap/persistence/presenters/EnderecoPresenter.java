package br.com.fiap.persistence.presenters;

import br.com.fiap.persistence.models.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class EnderecoPresenter implements Serializable {
    private String logradouro;
    private String numero;

    public EnderecoPresenter(Endereco endereco) {
        this.logradouro = endereco.getLogradouro();
        this.numero = endereco.getNumero();
    }

    public Endereco toModel(){
        Endereco endereco = new Endereco();
        endereco.setLogradouro(this.getLogradouro());
        endereco.setNumero(this.getNumero());
        return endereco;
    }

}
