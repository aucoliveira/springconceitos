package com.cursomc.Curso.services;

import com.cursomc.Curso.domain.Categoria;
import com.cursomc.Curso.services.exceptions.ObjectNotFoundException;
import com.cursomc.Curso.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    public Categoria findById(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow( ()-> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: "
                        + Categoria.class.getName()
        ));
    }
}
