package com.portalnoticias.apiportaldeportivo.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalnoticias.apiportaldeportivo.entity.EstadisticasJugador;
import com.portalnoticias.apiportaldeportivo.repository.EstadisticasJugadorRepository;
import com.portalnoticias.apiportaldeportivo.service.IEstadisticasJugadorService;

@Service
public class EstadisticasJugadorService implements IEstadisticasJugadorService {
    @Autowired
    private EstadisticasJugadorRepository repoEstadisticas;

    public List<EstadisticasJugador> buscarTodos() {
        return repoEstadisticas.findAll();
    }

    public void guardar(EstadisticasJugador estadistica) {
        repoEstadisticas.save(estadistica);
    }

    public void modificar(EstadisticasJugador estadistica) {
        repoEstadisticas.save(estadistica);
    }

    public Optional<EstadisticasJugador> buscarId(Integer id) {
        return repoEstadisticas.findById(id);
    }

    public void eliminar(Integer id) {
        repoEstadisticas.deleteById(id);
    }
}
