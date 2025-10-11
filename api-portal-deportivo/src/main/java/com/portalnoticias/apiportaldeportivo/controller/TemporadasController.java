package com.portalnoticias.apiportaldeportivo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalnoticias.apiportaldeportivo.entity.Temporadas;
import com.portalnoticias.apiportaldeportivo.service.ITemporadasService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/restful")
public class TemporadasController {
    @Autowired
    private ITemporadasService serviceTemporadas;

    @GetMapping("/temporadas")
    public List<Temporadas> buscarTodos() {
        return serviceTemporadas.buscarTodos();
    }

    @PostMapping("/temporadas")
    public Temporadas guardar(@RequestBody Temporadas temporada) {
        serviceTemporadas.guardar(temporada);
        return temporada;
    }

    @PutMapping("/temporadas")
    public Temporadas modificar(@RequestBody Temporadas temporada) {
        serviceTemporadas.modificar(temporada);
        return temporada;
    }

    @GetMapping("/temporadas/{id}")
    public Optional<Temporadas> buscarId(@PathVariable("id") Integer id) {
        return serviceTemporadas.buscarId(id);
    }

    @DeleteMapping("/temporadas/{id}")
    public String eliminar(@PathVariable Integer id) {
        serviceTemporadas.eliminar(id);
        return "Temporada eliminada";
    }
}
