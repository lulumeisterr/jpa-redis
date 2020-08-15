package br.com.fiap.persistence;

import java.util.ArrayList;
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

		
		List<Produto> prodList = new ArrayList<Produto>();
		
		
		Cliente c = new Cliente("Lucas", new Endereco("Rua X", "230"));
		Produto prod = new Produto("Moudr", 1, 200.0);
		Produto prod2 = new Produto("DSA", 1, 200.0);
		prodList.add(prod);
		prodList.add(prod2);
		
		Pedido p = new Pedido("Pedido 1000", new GregorianCalendar(2020 , Calendar.FEBRUARY , 20), 
				prodList, 
				c);
		
		pedidoService.add(p);
		
	}

}
