package com.portalnoticias.apiportaldeportivo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalnoticias.apiportaldeportivo.entity.Equipos;
import com.portalnoticias.apiportaldeportivo.service.IEquiposService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/restful")
public class EquiposController {
    @Autowired
    private IEquiposService serviceEquipos;

    @GetMapping("/equipos")
    public List<Equipos> buscarTodos() {
        return serviceEquipos.buscarTodos();
    }

    @PostMapping("/equipos")
    public Equipos guardar(@RequestBody Equipos equipo) {
        serviceEquipos.guardar(equipo);
        return equipo;
    }

    @PutMapping("/equipos")
    public Equipos modificar(@RequestBody Equipos equipo) {
        serviceEquipos.modificar(equipo);
        return equipo;
    }

    @GetMapping("/equipos/{id}")
    public Optional<Equipos> buscarId(@PathVariable("id") Integer id) {
        return serviceEquipos.buscarId(id);
    }

    @DeleteMapping("/equipos/{id}")
    public String eliminar(@PathVariable Integer id) {
        serviceEquipos.eliminar(id);
        return "Equipo eliminado";
    }
}
