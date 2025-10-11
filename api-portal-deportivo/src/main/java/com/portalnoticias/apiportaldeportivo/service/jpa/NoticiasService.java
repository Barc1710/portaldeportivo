package com.portalnoticias.apiportaldeportivo.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalnoticias.apiportaldeportivo.entity.Noticias;
import com.portalnoticias.apiportaldeportivo.repository.NoticiasRepository;
import com.portalnoticias.apiportaldeportivo.service.INoticiasService;

@Service
public class NoticiasService implements INoticiasService {
    @Autowired
    private NoticiasRepository repoNoticias;

    public List<Noticias> buscarTodos() {
        return repoNoticias.findAll();
    }

    public void guardar(Noticias noticia) {
        repoNoticias.save(noticia);
    }

    public void modificar(Noticias noticia) {
        repoNoticias.save(noticia);
    }

    public Optional<Noticias> buscarId(Integer id) {
        return repoNoticias.findById(id);
    }

    public void eliminar(Integer id) {
        repoNoticias.deleteById(id);
    }
}
