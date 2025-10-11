package com.portalnoticias.apiportaldeportivo.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalnoticias.apiportaldeportivo.entity.Temporadas;
import com.portalnoticias.apiportaldeportivo.repository.TemporadasRepository;
import com.portalnoticias.apiportaldeportivo.service.ITemporadasService;

@Service
public class TemporadasService implements ITemporadasService {
    @Autowired
    private TemporadasRepository repoTemporadas;

    public List<Temporadas> buscarTodos() {
        return repoTemporadas.findAll();
    }

    public void guardar(Temporadas temporada) {
        repoTemporadas.save(temporada);
    }

    public void modificar(Temporadas temporada) {
        repoTemporadas.save(temporada);
    }

    public Optional<Temporadas> buscarId(Integer id) {
        return repoTemporadas.findById(id);
    }

    public void eliminar(Integer id) {
        repoTemporadas.deleteById(id);
    }
}
