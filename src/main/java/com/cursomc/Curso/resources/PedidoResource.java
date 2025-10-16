package com.cursomc.Curso.resources;


import com.cursomc.Curso.domain.Pedido;
import com.cursomc.Curso.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {

        Pedido pedido = pedidoService.findById(id);
        return ResponseEntity.ok().body(pedido);
    }
}