package com.portalnoticias.apiportaldeportivo.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalnoticias.apiportaldeportivo.entity.Jugadores;
import com.portalnoticias.apiportaldeportivo.repository.JugadoresRepository;
import com.portalnoticias.apiportaldeportivo.service.IJugadoresService;

@Service
public class JugadoresService implements IJugadoresService {
    @Autowired
    private JugadoresRepository repoJugadores;

    public List<Jugadores> buscarTodos() {
        return repoJugadores.findAll();
    }

    public void guardar(Jugadores jugador) {
        repoJugadores.save(jugador);
    }

    public void modificar(Jugadores jugador) {
        repoJugadores.save(jugador);
    }

    public Optional<Jugadores> buscarId(Integer id) {
        return repoJugadores.findById(id);
    }

    public void eliminar(Integer id) {
        repoJugadores.deleteById(id);
    }
}
