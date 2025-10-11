package com.portalnoticias.apiportaldeportivo.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalnoticias.apiportaldeportivo.entity.Multimedia;
import com.portalnoticias.apiportaldeportivo.repository.MultimediaRepository;
import com.portalnoticias.apiportaldeportivo.service.IMultimediaService;

@Service
public class MultimediaService implements IMultimediaService {
    @Autowired
    private MultimediaRepository repoMultimedia;

    public List<Multimedia> buscarTodos() {
        return repoMultimedia.findAll();
    }

    public void guardar(Multimedia multimedia) {
        repoMultimedia.save(multimedia);
    }

    public void modificar(Multimedia multimedia) {
        repoMultimedia.save(multimedia);
    }

    public Optional<Multimedia> buscarId(Integer id) {
        return repoMultimedia.findById(id);
    }

    public void eliminar(Integer id) {
        repoMultimedia.deleteById(id);
    }
}
