package com.portalnoticias.apiportaldeportivo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalnoticias.apiportaldeportivo.entity.Categorias;
import com.portalnoticias.apiportaldeportivo.service.ICategoriasService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/restful")
public class CategoriasController {
    @Autowired
    private ICategoriasService serviceCategorias;

    @GetMapping("/categorias")
    public List<Categorias> buscarTodos() {
        return serviceCategorias.buscarTodos();
    }

    @PostMapping("/categorias")
    public Categorias guardar(@RequestBody Categorias categoria) {
        serviceCategorias.guardar(categoria);
        return categoria;
    }

    @PutMapping("/categorias")
    public Categorias modificar(@RequestBody Categorias categoria) {
        serviceCategorias.modificar(categoria);
        return categoria;
    }

    @GetMapping("/categorias/{id}")
    public Optional<Categorias> buscarId(@PathVariable("id") Integer id) {
        return serviceCategorias.buscarId(id);
    }

    @DeleteMapping("/categorias/{id}")
    public String eliminar(@PathVariable Integer id) {
        serviceCategorias.eliminar(id);
        return "Categoría eliminada";
    }
}
