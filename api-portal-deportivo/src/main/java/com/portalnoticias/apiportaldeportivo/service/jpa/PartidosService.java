package com.portalnoticias.apiportaldeportivo.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalnoticias.apiportaldeportivo.entity.Partidos;
import com.portalnoticias.apiportaldeportivo.repository.PartidosRepository;
import com.portalnoticias.apiportaldeportivo.service.IPartidosService;

@Service
public class PartidosService implements IPartidosService {
    @Autowired
    private PartidosRepository repoPartidos;

    public List<Partidos> buscarTodos() {
        return repoPartidos.findAll();
    }

    public void guardar(Partidos partido) {
        repoPartidos.save(partido);
    }

    public void modificar(Partidos partido) {
        repoPartidos.save(partido);
    }

    public Optional<Partidos> buscarId(Integer id) {
        return repoPartidos.findById(id);
    }

    public void eliminar(Integer id) {
        repoPartidos.deleteById(id);
    }
}
