package com.portalnoticias.apiportaldeportivo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalnoticias.apiportaldeportivo.entity.Comentarios;
import com.portalnoticias.apiportaldeportivo.service.IComentariosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/restful")
public class ComentariosController {
    @Autowired
    private IComentariosService serviceComentarios;

    @GetMapping("/comentarios")
    public List<Comentarios> buscarTodos() {
        return serviceComentarios.buscarTodos();
    }

    @PostMapping("/comentarios")
    public Comentarios guardar(@RequestBody Comentarios comentario) {
        serviceComentarios.guardar(comentario);
        return comentario;
    }

    @PutMapping("/comentarios")
    public Comentarios modificar(@RequestBody Comentarios comentario) {
        serviceComentarios.modificar(comentario);
        return comentario;
    }

    @GetMapping("/comentarios/{id}")
    public Optional<Comentarios> buscarId(@PathVariable("id") Integer id) {
        return serviceComentarios.buscarId(id);
    }

    @DeleteMapping("/comentarios/{id}")
    public String eliminar(@PathVariable Integer id) {
        serviceComentarios.eliminar(id);
        return "Comentario eliminado";
    }
}
