package com.portalnoticias.apiportaldeportivo.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalnoticias.apiportaldeportivo.entity.Roles;
import com.portalnoticias.apiportaldeportivo.repository.RolesRepository;
import com.portalnoticias.apiportaldeportivo.service.IRolesService;

@Service
public class RolesService implements IRolesService {
    @Autowired
    private RolesRepository repoRoles;

    public List<Roles> buscarTodos() {
        return repoRoles.findAll();
    }

    public void guardar(Roles rol) {
        repoRoles.save(rol);
    }

    public void modificar(Roles rol) {
        repoRoles.save(rol);
    }

    public Optional<Roles> buscarId(Integer id) {
        return repoRoles.findById(id);
    }

    public void eliminar(Integer id) {
        repoRoles.deleteById(id);
    }
}
