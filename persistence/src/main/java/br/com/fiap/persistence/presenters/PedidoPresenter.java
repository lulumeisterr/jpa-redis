package br.com.fiap.persistence.presenters;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.persistence.models.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

@Getter
@Setter
@NoArgsConstructor
public class PedidoPresenter implements Serializable {

	private Long codigo;
	private String descricao;
	private LocalDateTime data;
	private List<ProdutoPresenter> produtos;
	
	public PedidoPresenter(Pedido pedido) {
		this.codigo = pedido.getCodigo();
		this.descricao = pedido.getDescricao();
		this.data=pedido.getData();
		this.produtos=pedido.getProdutos().stream().map(ProdutoPresenter::new).collect(Collectors.toList());
	}

	public Pedido toModel(){
		Pedido pedido = new Pedido();
		pedido.setCodigo(this.getCodigo());
		pedido.setDescricao(this.getDescricao());
		pedido.setData(this.getData());
		if(!CollectionUtils.isEmpty(this.getProdutos())) {
			pedido.setProdutos(this.getProdutos().stream().map(ProdutoPresenter::toModel).collect(Collectors.toList()));
		}
		return pedido;
	}

}
