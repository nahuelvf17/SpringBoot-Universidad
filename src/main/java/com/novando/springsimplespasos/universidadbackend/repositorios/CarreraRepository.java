package com.novando.springsimplespasos.universidadbackend.repositorios;

import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Carrera;
import org.springframework.data.repository.CrudRepository;

public interface CarreraRepository extends CrudRepository<Carrera, Integer> {
    Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    //@Query("select c from Carrera c where c.cantidadAnios > ?1")
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
}
