package com.portalnoticias.apiportaldeportivo.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalnoticias.apiportaldeportivo.entity.Categorias;
import com.portalnoticias.apiportaldeportivo.repository.CategoriasRepository;
import com.portalnoticias.apiportaldeportivo.service.ICategoriasService;

@Service
public class CategoriasService implements ICategoriasService {
    @Autowired
    private CategoriasRepository repoCategorias;

    public List<Categorias> buscarTodos() {
        return repoCategorias.findAll();
    }

    public void guardar(Categorias categoria) {
        repoCategorias.save(categoria);
    }

    public void modificar(Categorias categoria) {
        repoCategorias.save(categoria);
    }

    public Optional<Categorias> buscarId(Integer id) {
        return repoCategorias.findById(id);
    }

    public void eliminar(Integer id) {
        repoCategorias.deleteById(id);
    }
}
