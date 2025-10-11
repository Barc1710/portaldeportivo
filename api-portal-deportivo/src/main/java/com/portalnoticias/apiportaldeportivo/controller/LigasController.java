package com.portalnoticias.apiportaldeportivo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalnoticias.apiportaldeportivo.entity.Ligas;
import com.portalnoticias.apiportaldeportivo.service.ILigasService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/restful")
public class LigasController {
    @Autowired
    private ILigasService serviceLigas;

    @GetMapping("/ligas")
    public List<Ligas> buscarTodos() {
        return serviceLigas.buscarTodos();
    }

    @PostMapping("/ligas")
    public Ligas guardar(@RequestBody Ligas liga) {
        serviceLigas.guardar(liga);
        return liga;
    }

    @PutMapping("/ligas")
    public Ligas modificar(@RequestBody Ligas liga) {
        serviceLigas.modificar(liga);
        return liga;
    }

    @GetMapping("/ligas/{id}")
    public Optional<Ligas> buscarId(@PathVariable("id") Integer id) {
        return serviceLigas.buscarId(id);
    }

    @DeleteMapping("/ligas/{id}")
    public String eliminar(@PathVariable Integer id) {
        serviceLigas.eliminar(id);
        return "Liga eliminada";
    }
}
