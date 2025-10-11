package com.portalnoticias.apiportaldeportivo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalnoticias.apiportaldeportivo.entity.Partidos;
import com.portalnoticias.apiportaldeportivo.service.IPartidosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/restful")
public class PartidosController {
    @Autowired
    private IPartidosService servicePartidos;

    @GetMapping("/partidos")
    public List<Partidos> buscarTodos() {
        return servicePartidos.buscarTodos();
    }

    @PostMapping("/partidos")
    public Partidos guardar(@RequestBody Partidos partido) {
        servicePartidos.guardar(partido);
        return partido;
    }

    @PutMapping("/partidos")
    public Partidos modificar(@RequestBody Partidos partido) {
        servicePartidos.modificar(partido);
        return partido;
    }

    @GetMapping("/partidos/{id}")
    public Optional<Partidos> buscarId(@PathVariable("id") Integer id) {
        return servicePartidos.buscarId(id);
    }

    @DeleteMapping("/partidos/{id}")
    public String eliminar(@PathVariable Integer id) {
        servicePartidos.eliminar(id);
        return "Partido eliminado";
    }
}
