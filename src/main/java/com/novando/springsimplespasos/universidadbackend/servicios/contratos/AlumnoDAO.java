package com.novando.springsimplespasos.universidadbackend.servicios.contratos;

import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Persona;

public interface AlumnoDAO extends PersonaDAO{
    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);
}
