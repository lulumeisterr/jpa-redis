package br.com.fiap.persistence.presenters;

import br.com.fiap.persistence.models.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ClientePresenter implements Serializable {
    private Long codigo;
    private String nome;
    private EnderecoPresenter endereco;
    private List<PedidoPresenter> pedidos;

    public ClientePresenter(Cliente cliente) {
        this.codigo = cliente.getCodigo();
        this.nome = cliente.getNome();
        this.endereco = new EnderecoPresenter(cliente.getEndereco());
        if(!CollectionUtils.isEmpty(cliente.getPedidos())) {
            this.pedidos = cliente.getPedidos().stream().map(PedidoPresenter::new).collect(Collectors.toList());
        }
    }

    public Cliente toModel(){
        Cliente cliente = new Cliente();
        cliente.setCodigo(this.getCodigo());
        cliente.setNome(this.getNome());
        cliente.setEndereco(this.getEndereco().toModel());
        if(!CollectionUtils.isEmpty(this.getPedidos())) {
            cliente.setPedidos(this.getPedidos().stream().map(PedidoPresenter::toModel).collect(Collectors.toList()));
        }
        return cliente;
    }


}
