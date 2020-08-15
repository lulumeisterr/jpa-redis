package br.com.fiap.persistence;

import br.com.fiap.persistence.models.Cliente;
import br.com.fiap.persistence.models.Endereco;
import br.com.fiap.persistence.models.Pedido;
import br.com.fiap.persistence.models.Produto;
import br.com.fiap.persistence.services.ClienteService;
import br.com.fiap.persistence.services.PedidoService;
import br.com.fiap.persistence.services.ProdutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class CmdRunner implements CommandLineRunner {
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    private static final Logger log = LoggerFactory.getLogger(PersistenceApplication.class);

    @Override
    public void run(String... args) throws Exception {

        clienteService.deleteAll();

        Cliente gab= clienteService.add(new Cliente("Gabriel", new Endereco("Rua Z", "3030")));

        clienteService.findById(gab.getCodigo());

        List<Produto> prodList = new ArrayList<Produto>();

        Cliente c = new Cliente("Lucas", new Endereco("Rua X", "230"));
        Produto prod = new Produto("Moudr", 1, 200.0);
        Produto prod2 = new Produto("DSA", 1, 200.0);
        prodList.add(prod);
        prodList.add(prod2);

        Pedido p = new Pedido("Pedido 1000", LocalDateTime.of(2020, Month.FEBRUARY, 20, 11, 30, 51),
                prodList,
                c);

        pedidoService.add(p);

    }

}
