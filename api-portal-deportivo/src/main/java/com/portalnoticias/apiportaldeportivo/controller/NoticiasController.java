package com.portalnoticias.apiportaldeportivo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalnoticias.apiportaldeportivo.entity.Noticias;
import com.portalnoticias.apiportaldeportivo.service.INoticiasService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/restful")
public class NoticiasController {
    @Autowired
    private INoticiasService serviceNoticias;

    @GetMapping("/noticias")
    public List<Noticias> buscarTodos() {
        return serviceNoticias.buscarTodos();
    }

    @PostMapping("/noticias")
    public Noticias guardar(@RequestBody Noticias noticia) {
        serviceNoticias.guardar(noticia);
        return noticia;
    }

    @PutMapping("/noticias")
    public Noticias modificar(@RequestBody Noticias noticia) {
        serviceNoticias.modificar(noticia);
        return noticia;
    }

    @GetMapping("/noticias/{id}")
    public Optional<Noticias> buscarId(@PathVariable("id") Integer id) {
        return serviceNoticias.buscarId(id);
    }

    @DeleteMapping("/noticias/{id}")
    public String eliminar(@PathVariable Integer id) {
        serviceNoticias.eliminar(id);
        return "Noticia eliminada";
    }
}
