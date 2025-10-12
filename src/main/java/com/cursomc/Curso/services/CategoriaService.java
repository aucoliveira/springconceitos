package com.cursomc.Curso.services;

import com.cursomc.Curso.domain.Categoria;
import com.cursomc.Curso.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    public Categoria findById(Integer id) {
        Categoria categoria = categoriaRepository.findById(id).get();
        return categoria;
    }
}
