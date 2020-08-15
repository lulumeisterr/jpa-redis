package br.com.fiap.persistence.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.persistence.bean.Pedido;
import br.com.fiap.persistence.repository.PedidoRepository;

@Component
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public void add(Pedido pedido) {
    	pedidoRepository.save(pedido);
    }

    @Transactional()
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Transactional
    public void addAll(Collection<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
        	pedidoRepository.save(pedido);
        }
    }
	
}
