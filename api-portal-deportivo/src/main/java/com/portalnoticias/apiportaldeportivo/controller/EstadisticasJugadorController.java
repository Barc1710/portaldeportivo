package com.portalnoticias.apiportaldeportivo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalnoticias.apiportaldeportivo.entity.EstadisticasJugador;
import com.portalnoticias.apiportaldeportivo.service.IEstadisticasJugadorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/restful")
public class EstadisticasJugadorController {
    @Autowired
    private IEstadisticasJugadorService serviceEstadisticas;

    @GetMapping("/estadisticas")
    public List<EstadisticasJugador> buscarTodos() {
        return serviceEstadisticas.buscarTodos();
    }

    @PostMapping("/estadisticas")
    public EstadisticasJugador guardar(@RequestBody EstadisticasJugador estadistica) {
        serviceEstadisticas.guardar(estadistica);
        return estadistica;
    }

    @PutMapping("/estadisticas")
    public EstadisticasJugador modificar(@RequestBody EstadisticasJugador estadistica) {
        serviceEstadisticas.modificar(estadistica);
        return estadistica;
    }

    @GetMapping("/estadisticas/{id}")
    public Optional<EstadisticasJugador> buscarId(@PathVariable("id") Integer id) {
        return serviceEstadisticas.buscarId(id);
    }

    @DeleteMapping("/estadisticas/{id}")
    public String eliminar(@PathVariable Integer id) {
        serviceEstadisticas.eliminar(id);
        return "Estadística eliminada";
    }
}
