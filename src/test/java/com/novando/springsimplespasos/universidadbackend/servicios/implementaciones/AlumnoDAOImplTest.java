package com.novando.springsimplespasos.universidadbackend.servicios.implementaciones;

import com.novando.springsimplespasos.universidadbackend.repositorios.AlumnoRepository;
import com.novando.springsimplespasos.universidadbackend.servicios.contratos.AlumnoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class AlumnoDAOImplTest {

    @MockBean
    AlumnoRepository alumnoRepository;

    @Autowired
    AlumnoDAO alumnoDAO;


    @BeforeEach
    void setUp() {
    }

    @Test
    void buscarAlumnosPorNombreCarrera() {
        // WHEN
        alumnoDAO.buscarAlumnosPorNombreCarrera(anyString());

        // THEN
        verify(alumnoRepository).buscarAlumnosPorNombreCarrera(anyString());
    }
}