package com.novando.springsimplespasos.universidadbackend.servicios.contratos;

import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Persona;

import java.util.Optional;

public interface GenericoDAO <E> {
    Optional<E> findById(Integer id);
    E save(E entidad);
    Iterable<E> findAll();
    void deleteById(Integer id);
}
