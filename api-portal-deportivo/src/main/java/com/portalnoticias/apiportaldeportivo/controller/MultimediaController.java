package com.portalnoticias.apiportaldeportivo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalnoticias.apiportaldeportivo.entity.Multimedia;
import com.portalnoticias.apiportaldeportivo.service.IMultimediaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/restful")
public class MultimediaController {
    @Autowired
    private IMultimediaService serviceMultimedia;

    @GetMapping("/multimedia")
    public List<Multimedia> buscarTodos() {
        return serviceMultimedia.buscarTodos();
    }

    @PostMapping("/multimedia")
    public Multimedia guardar(@RequestBody Multimedia multimedia) {
        serviceMultimedia.guardar(multimedia);
        return multimedia;
    }

    @PutMapping("/multimedia")
    public Multimedia modificar(@RequestBody Multimedia multimedia) {
        serviceMultimedia.modificar(multimedia);
        return multimedia;
    }

    @GetMapping("/multimedia/{id}")
    public Optional<Multimedia> buscarId(@PathVariable("id") Integer id) {
        return serviceMultimedia.buscarId(id);
    }

    @DeleteMapping("/multimedia/{id}")
    public String eliminar(@PathVariable Integer id) {
        serviceMultimedia.eliminar(id);
        return "Multimedia eliminada";
    }
}
