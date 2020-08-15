package br.com.fiap.persistence.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.persistence.models.Pedido;
import br.com.fiap.persistence.presenters.PedidoPresenter;
import br.com.fiap.persistence.repository.PedidoRepository;

@Component
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public void add(PedidoPresenter pedido) {
    	Pedido pedidoBase = new Pedido();
		pedidoBase.setCodigo(pedido.getCodigo());
		pedidoBase.setDescricao(pedido.getDescricao());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(pedido.getData(), formatter);
		pedidoBase.setData(dateTime);
    	pedidoRepository.save(pedidoBase);
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Transactional
    public void addAll(Collection<PedidoPresenter> pedidos) {
        for (PedidoPresenter pedido : pedidos) {
        	Pedido pedidoBase = new Pedido();
    		pedidoBase.setCodigo(pedido.getCodigo());
    		pedidoBase.setDescricao(pedido.getDescricao());
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    		LocalDateTime dateTime = LocalDateTime.parse(pedido.getData(), formatter);
    		pedidoBase.setData(dateTime);
        	pedidoRepository.save(pedidoBase);
        }
    }
    
    public Optional<Pedido> findById(Long codigo) {
    	return pedidoRepository.findById(codigo);
    }
    
    public void deleteById(Long codigo) {
    	pedidoRepository.deleteById(codigo);
    }
    
    
    
    
	
}
