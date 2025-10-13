package com.cursomc.Curso;

import com.cursomc.Curso.domain.*;
import com.cursomc.Curso.domain.enums.TipoCliente;
import com.cursomc.Curso.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;


@SpringBootApplication
public class CursoApplication implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;
	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}
    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().add(p3);

        p1.getCategorias().add(cat1);
        p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
        p3.getCategorias().add(cat1);

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
        produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlandia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().add(c1);
        est2.getCidades().addAll(Arrays.asList(c2,c3));

        estadoRepository.saveAll(Arrays.asList(est1,est2));
        cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com","23654898542",
                TipoCliente.PESSOAFISICA);

        cli1.getTelefones().addAll(Arrays.asList("00000000000", "11111111111"));

        Endereco e1 = new Endereco(null, "Rua 7", "256", "Casa Alta","Tabapuá",
                "61635270", cli1, c1);

        Endereco e2 = new Endereco(null, "Rua 10", "586", "comercio",
                "Antonio Bezerra","61635270", cli1, c2);


        cli1.getEnderecos().addAll(Arrays.asList(e1,e2));

        clienteRepository.save(cli1);
        enderecoRepository.saveAll(Arrays.asList(e1,e2));
    }
}
