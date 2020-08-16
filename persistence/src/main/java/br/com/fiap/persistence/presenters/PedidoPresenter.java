package br.com.fiap.persistence.presenters;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.fiap.persistence.models.Pedido;
import br.com.fiap.persistence.models.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PedidoPresenter implements Serializable {

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	private Long codigo;
	
	private String descricao;
	
	private String data;
	
	public PedidoPresenter(Pedido pedido) {
		this.codigo = pedido.getCodigo();
		this.descricao = pedido.getDescricao();
		String dataFormatada = pedido.getData().format(formatter);
		this.data = dataFormatada;
	}

	public Pedido toModel(){
		Pedido pedido = new Pedido(){{
			setCodigo(this.getCodigo());
			setDescricao(this.getDescricao());
			if(this.getData()!=null) {
				setData(LocalDateTime.parse(data, formatter));
			}
		}};
		return pedido;
	}

}
