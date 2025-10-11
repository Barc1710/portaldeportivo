package com.portalnoticias.apiportaldeportivo.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalnoticias.apiportaldeportivo.entity.Equipos;
import com.portalnoticias.apiportaldeportivo.repository.EquiposRepository;
import com.portalnoticias.apiportaldeportivo.service.IEquiposService;

@Service
public class EquiposService implements IEquiposService {
    @Autowired
    private EquiposRepository repoEquipos;

    public List<Equipos> buscarTodos() {
        return repoEquipos.findAll();
    }

    public void guardar(Equipos equipo) {
        repoEquipos.save(equipo);
    }

    public void modificar(Equipos equipo) {
        repoEquipos.save(equipo);
    }

    public Optional<Equipos> buscarId(Integer id) {
        return repoEquipos.findById(id);
    }

    public void eliminar(Integer id) {
        repoEquipos.deleteById(id);
    }
}
