package com.novando.springsimplespasos.universidadbackend.servicios.implementaciones;

import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Persona;
import com.novando.springsimplespasos.universidadbackend.repositorios.PersonaRepository;
import com.novando.springsimplespasos.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonaDAOImpl extends GenericoDAOImpl<Persona, PersonaRepository> implements PersonaDAO {

    public PersonaDAOImpl(PersonaRepository repository) {
        super(repository);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
        return repository.buscarPorNombreYApellido(nombre, apellido);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Persona> buscarPorDni(String dni) {
        return repository.buscarPorDni(dni);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Persona> BuscarPersonasPorApellido(String apellido) {
        return repository.buscarPersonasPorApellido(apellido);
    }
}
