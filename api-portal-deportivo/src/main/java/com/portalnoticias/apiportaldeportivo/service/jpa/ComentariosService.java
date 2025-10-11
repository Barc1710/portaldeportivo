package com.portalnoticias.apiportaldeportivo.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalnoticias.apiportaldeportivo.entity.Comentarios;
import com.portalnoticias.apiportaldeportivo.repository.ComentariosRepository;
import com.portalnoticias.apiportaldeportivo.service.IComentariosService;

@Service
public class ComentariosService implements IComentariosService {
    @Autowired
    private ComentariosRepository repoComentarios;

    public List<Comentarios> buscarTodos() {
        return repoComentarios.findAll();
    }

    public void guardar(Comentarios comentario) {
        repoComentarios.save(comentario);
    }

    public void modificar(Comentarios comentario) {
        repoComentarios.save(comentario);
    }

    public Optional<Comentarios> buscarId(Integer id) {
        return repoComentarios.findById(id);
    }

    public void eliminar(Integer id) {
        repoComentarios.deleteById(id);
    }
}
