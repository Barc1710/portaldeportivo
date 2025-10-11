package com.portalnoticias.apiportaldeportivo.service;

import java.util.List;
import java.util.Optional;

import com.portalnoticias.apiportaldeportivo.entity.Roles;

public interface IRolesService {
    // CRUD para el API de Roles

    List<Roles> buscarTodos();
    // Método para listar todos los roles

    void guardar(Roles rol);
    // Método para guardar roles

    void modificar(Roles rol);
    // Método para modificar roles

    Optional<Roles> buscarId(Integer id);
    // Método para listar un rol

    void eliminar(Integer id);
    // Método para eliminar un rol
}
