package com.cursomc.Curso.services;

import com.cursomc.Curso.domain.Categoria;
import com.cursomc.Curso.domain.Pedido;
import com.cursomc.Curso.repositories.CategoriaRepository;
import com.cursomc.Curso.repositories.PedidoRepository;
import com.cursomc.Curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    public Pedido findById(Integer id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);
        return obj.orElseThrow( ()-> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: "
                        + Pedido.class.getName()
        ));
    }
}
