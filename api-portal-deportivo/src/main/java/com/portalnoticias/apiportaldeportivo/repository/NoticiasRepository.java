package com.portalnoticias.apiportaldeportivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portalnoticias.apiportaldeportivo.entity.Noticias;

public interface NoticiasRepository extends JpaRepository<Noticias, Integer> {

}
