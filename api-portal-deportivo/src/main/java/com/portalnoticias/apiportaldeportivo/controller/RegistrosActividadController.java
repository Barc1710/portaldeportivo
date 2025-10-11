package com.portalnoticias.apiportaldeportivo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalnoticias.apiportaldeportivo.entity.RegistrosActividad;
import com.portalnoticias.apiportaldeportivo.service.IRegistrosActividadService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/restful")
public class RegistrosActividadController {
    @Autowired
    private IRegistrosActividadService serviceRegistrosActividad;

    @GetMapping("/registros-actividad")
    public List<RegistrosActividad> buscarTodos() {
        return serviceRegistrosActividad.buscarTodos();
    }

    @PostMapping("/registros-actividad")
    public RegistrosActividad guardar(@RequestBody RegistrosActividad registro) {
        serviceRegistrosActividad.guardar(registro);
        return registro;
    }

    @PutMapping("/registros-actividad")
    public RegistrosActividad modificar(@RequestBody RegistrosActividad registro) {
        serviceRegistrosActividad.modificar(registro);
        return registro;
    }

    @GetMapping("/registros-actividad/{id}")
    public Optional<RegistrosActividad> buscarId(@PathVariable("id") Integer id) {
        return serviceRegistrosActividad.buscarId(id);
    }

    @DeleteMapping("/registros-actividad/{id}")
    public String eliminar(@PathVariable Integer id) {
        serviceRegistrosActividad.eliminar(id);
        return "Registro de actividad eliminado";
    }
}
