package com.cursomc.Curso;

import com.cursomc.Curso.domain.Categoria;
import com.cursomc.Curso.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
public class CursoApplication implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;
	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
    }
}
