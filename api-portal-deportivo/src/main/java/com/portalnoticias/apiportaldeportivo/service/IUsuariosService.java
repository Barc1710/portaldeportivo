package com.portalnoticias.apiportaldeportivo.service;

import java.util.List;
import java.util.Optional;

import com.portalnoticias.apiportaldeportivo.entity.Usuarios;

public interface IUsuariosService {
    // CRUD para el API de Usuarios

    List<Usuarios> buscarTodos();
    // Método para listar todos los usuarios

    void guardar(Usuarios usuario);
    // Método para guardar usuarios

    void modificar(Usuarios usuario);
    // Método para modificar usuarios

    Optional<Usuarios> buscarId(Integer id);
    // Método para listar un usuario

    void eliminar(Integer id);
    // Método para eliminar un usuario
}
