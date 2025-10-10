package com.cursomc.Curso.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// IMPORTAÇÃO A SER REMOVIDA:
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @GetMapping
    public String listar() {
        return "REST está funcionando";
    }
}