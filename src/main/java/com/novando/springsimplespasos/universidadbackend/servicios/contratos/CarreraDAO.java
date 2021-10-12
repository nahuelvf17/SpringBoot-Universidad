package com.novando.springsimplespasos.universidadbackend.servicios.contratos;

import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Carrera;

import java.util.Optional;

public interface CarreraDAO extends GenericoDAO<Carrera>{
    Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    //@Query("select c from Carrera c where c.cantidadAnios > ?1")
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
}
