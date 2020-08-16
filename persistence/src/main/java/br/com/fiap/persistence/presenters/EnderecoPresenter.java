package br.com.fiap.persistence.presenters;

import br.com.fiap.persistence.models.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class EnderecoPresenter implements Serializable {
    private String logradouro;
    private String numero;

    public EnderecoPresenter(Endereco endereco) {
        this.logradouro = endereco.getLogradouro();
        this.numero = endereco.getNumero();
    }

    public Endereco toModel(){
        Endereco endereco = new Endereco(){{
            setLogradouro(this.getLogradouro());
            setNumero(this.getNumero());
        }};
        return endereco;
    }

}
