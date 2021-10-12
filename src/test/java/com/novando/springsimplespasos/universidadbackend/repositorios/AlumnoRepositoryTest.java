package com.novando.springsimplespasos.universidadbackend.repositorios;

import com.novando.springsimplespasos.universidadbackend.datos.DatosDummy;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Alumno;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Carrera;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Persona;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import java.util.Arrays;
import java.util.DuplicateFormatFlagsException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AlumnoRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumnos")
    PersonaRepository alumnoRepository;

    @Autowired
    CarreraRepository carreraRepository;

    @Test
    void buscarAlumnosPorNombreCarrera(){
        //GIVEN

        Iterable<Persona> personas = alumnoRepository.saveAll(
                Arrays.asList(DatosDummy.alumno01(),
                        DatosDummy.alumno02(),
                        DatosDummy.alumno03()));

        Carrera save = carreraRepository.save(DatosDummy.carrera01(false));

        personas.forEach(alumno->((Alumno)alumno).setCarrera(save));
        alumnoRepository.saveAll(personas);

        // WHEN
        String carreraNombre = "Ingenieria en Sistemas";
        List<Persona> expected = (List<Persona>) ((AlumnoRepository)alumnoRepository).buscarAlumnosPorNombreCarrera(carreraNombre);

        // THEN
        assertThat(expected.size()==3).isTrue();
    }

}