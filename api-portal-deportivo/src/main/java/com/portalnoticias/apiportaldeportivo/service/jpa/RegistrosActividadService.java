package com.portalnoticias.apiportaldeportivo.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalnoticias.apiportaldeportivo.entity.RegistrosActividad;
import com.portalnoticias.apiportaldeportivo.repository.RegistrosActividadRepository;
import com.portalnoticias.apiportaldeportivo.service.IRegistrosActividadService;

@Service
public class RegistrosActividadService implements IRegistrosActividadService {
    @Autowired
    private RegistrosActividadRepository repoRegistrosActividad;

    public List<RegistrosActividad> buscarTodos() {
        return repoRegistrosActividad.findAll();
    }

    public void guardar(RegistrosActividad registro) {
        repoRegistrosActividad.save(registro);
    }

    public void modificar(RegistrosActividad registro) {
        repoRegistrosActividad.save(registro);
    }

    public Optional<RegistrosActividad> buscarId(Integer id) {
        return repoRegistrosActividad.findById(id);
    }

    public void eliminar(Integer id) {
        repoRegistrosActividad.deleteById(id);
    }
}
