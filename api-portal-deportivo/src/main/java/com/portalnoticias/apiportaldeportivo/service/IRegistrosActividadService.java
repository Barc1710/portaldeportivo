package com.portalnoticias.apiportaldeportivo.service;

import java.util.List;
import java.util.Optional;

import com.portalnoticias.apiportaldeportivo.entity.RegistrosActividad;

public interface IRegistrosActividadService {
    List<RegistrosActividad> buscarTodos();

    void guardar(RegistrosActividad registro);

    void modificar(RegistrosActividad registro);

    Optional<RegistrosActividad> buscarId(Integer id);

    void eliminar(Integer id);
}
