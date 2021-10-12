package com.novando.springsimplespasos.universidadbackend.servicios.contratos;

import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericoDAO<Persona>{
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
    Optional<Persona> buscarPorDni(String dni);
    Iterable<Persona> BuscarPersonasPorApellido(String apellido);
}
