package com.cursomc.Curso.resources;


import com.cursomc.Curso.domain.Cliente;
import com.cursomc.Curso.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;
    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {

        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok().body(cliente);
    }
}