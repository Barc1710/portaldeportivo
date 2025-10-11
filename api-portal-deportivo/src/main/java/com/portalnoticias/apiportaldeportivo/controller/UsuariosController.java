package com.portalnoticias.apiportaldeportivo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalnoticias.apiportaldeportivo.entity.Usuarios;
import com.portalnoticias.apiportaldeportivo.service.IUsuariosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/restful")
public class UsuariosController {
    @Autowired
    private IUsuariosService serviceUsuarios;

    @GetMapping("/usuarios")
    public List<Usuarios> buscarTodos() {
        return serviceUsuarios.buscarTodos();
    }

    @PostMapping("/usuarios")
    public Usuarios guardar(@RequestBody Usuarios usuario) {
        serviceUsuarios.guardar(usuario);
        return usuario;
    }

    @PutMapping("/usuarios")
    public Usuarios modificar(@RequestBody Usuarios usuario) {
        serviceUsuarios.modificar(usuario);
        return usuario;
    }

    @GetMapping("/usuarios/{id}")
    public Optional<Usuarios> buscarId(@PathVariable("id") Integer id) {
        return serviceUsuarios.buscarId(id);
    }

    @DeleteMapping("/usuarios/{id}")
    public String eliminar(@PathVariable Integer id) {
        serviceUsuarios.eliminar(id);
        return "Usuario eliminado";
    }
}
