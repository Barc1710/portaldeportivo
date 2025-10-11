package com.portalnoticias.apiportaldeportivo.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalnoticias.apiportaldeportivo.entity.Ligas;
import com.portalnoticias.apiportaldeportivo.repository.LigasRepository;
import com.portalnoticias.apiportaldeportivo.service.ILigasService;

@Service
public class LigasService implements ILigasService {
    @Autowired
    private LigasRepository repoLigas;

    public List<Ligas> buscarTodos() {
        return repoLigas.findAll();
    }

    public void guardar(Ligas liga) {
        repoLigas.save(liga);
    }

    public void modificar(Ligas liga) {
        repoLigas.save(liga);
    }

    public Optional<Ligas> buscarId(Integer id) {
        return repoLigas.findById(id);
    }

    public void eliminar(Integer id) {
        repoLigas.deleteById(id);
    }
}
