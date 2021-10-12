package com.novando.springsimplespasos.universidadbackend.servicios.implementaciones;

import com.novando.springsimplespasos.universidadbackend.repositorios.AlumnoRepository;
import com.novando.springsimplespasos.universidadbackend.servicios.contratos.PersonaDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonaDAOImplTest {

    PersonaDAO personaDAO;

    @Mock
    AlumnoRepository alumnoRepository;

    @BeforeEach
    void setUp() {
        personaDAO = new PersonaDAOImpl(alumnoRepository);
    }

    @Test
    void buscarPorNombreYApellido() {
        // WHEN
        personaDAO.buscarPorNombreYApellido(anyString(), anyString());

        //THEN

        verify(alumnoRepository).buscarPorNombreYApellido(anyString(), anyString());
    }

    @Test
    void buscarPorDni() {
        // WHEN
        personaDAO.buscarPorDni(anyString());

        //THEN

        verify(alumnoRepository).buscarPorDni(anyString());
    }

    @Test
    void buscarPersonasPorApellido() {
        // WHEN
        personaDAO.BuscarPersonasPorApellido(anyString());

        //THEN

        verify(alumnoRepository).buscarPersonasPorApellido(anyString());
    }
}