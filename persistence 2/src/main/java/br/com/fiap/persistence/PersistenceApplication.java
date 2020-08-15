package br.com.fiap.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.fiap.persistence.bean.Cliente;
import br.com.fiap.persistence.bean.Endereco;
import br.com.fiap.persistence.bean.Pedido;
import br.com.fiap.persistence.bean.Produto;
import br.com.fiap.persistence.service.ClienteService;
import br.com.fiap.persistence.service.PedidoService;
import br.com.fiap.persistence.service.ProdutoService;


@SpringBootApplication()
@EnableJpaRepositories("br.com.fiap")
@ComponentScan("br.com.fiap")
public class PersistenceApplication implements CommandLineRunner{
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ClienteService clienteService;
	
    private static final Logger log = LoggerFactory.getLogger(PersistenceApplication.class);
    
	public static void main(String[] args) {
		SpringApplication.run(PersistenceApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		log.info("StartApplication...");
		
		Pedido pedido = null;
		Cliente cliente = null;
		ArrayList<Produto> listaProduto = new ArrayList<Produto>();
		
		Produto produto1  = new Produto("Mouse Razer" , 1 , 300.5);
		Produto produto2  = new Produto("Mouse Steelseries" , 1 , 600.5);
		
		listaProduto.add(produto1);
		listaProduto.add(produto2);
		
		//2 -  Cada pedido possui um ou mais produtos e um cliente associado a
		//esse pedido. 
		
		// Um produto pode aparecer em um ou mais pedidos. 
	
		cliente = new Cliente("Lucas", new Endereco("Rua X","230"));
		
		pedido = new Pedido("Produtos Razer", new GregorianCalendar(2020 , Calendar.FEBRUARY , 20), listaProduto, Arrays.asList(cliente));
		pedido = new Pedido("Produtos Logitech", new GregorianCalendar(2020 , Calendar.FEBRUARY , 20), listaProduto, Arrays.asList(cliente));
		
		pedidoService.add(pedido);
		
	}



}
