package com.cursomc.Curso.services;

import com.cursomc.Curso.domain.Categoria;
import com.cursomc.Curso.domain.Cliente;
import com.cursomc.Curso.repositories.ClienteRepository;
import com.cursomc.Curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    public Cliente findById(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow( ()-> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: "
                        + Categoria.class.getName()
        ));
    }
}
