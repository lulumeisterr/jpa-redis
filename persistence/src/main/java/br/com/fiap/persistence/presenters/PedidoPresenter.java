package br.com.fiap.persistence.presenters;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import br.com.fiap.persistence.models.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PedidoPresenter implements Serializable {
	
	private Long codigo;
	
	private String descricao;
	
	private String data;
	
	public PedidoPresenter(Pedido pedido) {
		this.codigo = pedido.getCodigo();
		this.descricao = pedido.getDescricao();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = pedido.getData().format(formatter);
		this.data = dataFormatada;
	}



	
	
	

}
