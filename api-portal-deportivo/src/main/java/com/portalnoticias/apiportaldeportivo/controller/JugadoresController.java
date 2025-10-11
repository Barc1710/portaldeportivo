package com.portalnoticias.apiportaldeportivo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalnoticias.apiportaldeportivo.entity.Jugadores;
import com.portalnoticias.apiportaldeportivo.service.IJugadoresService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/restful")
public class JugadoresController {
    @Autowired
    private IJugadoresService serviceJugadores;

    @GetMapping("/jugadores")
    public List<Jugadores> buscarTodos() {
        return serviceJugadores.buscarTodos();
    }

    @PostMapping("/jugadores")
    public Jugadores guardar(@RequestBody Jugadores jugador) {
        serviceJugadores.guardar(jugador);
        return jugador;
    }

    @PutMapping("/jugadores")
    public Jugadores modificar(@RequestBody Jugadores jugador) {
        serviceJugadores.modificar(jugador);
        return jugador;
    }

    @GetMapping("/jugadores/{id}")
    public Optional<Jugadores> buscarId(@PathVariable("id") Integer id) {
        return serviceJugadores.buscarId(id);
    }

    @DeleteMapping("/jugadores/{id}")
    public String eliminar(@PathVariable Integer id) {
        serviceJugadores.eliminar(id);
        return "Jugador eliminado";
    }
}
