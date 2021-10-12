package com.novando.springsimplespasos.universidadbackend.repositorios;

import com.novando.springsimplespasos.universidadbackend.datos.DatosDummy;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Empleado;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Persona;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Profesor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class PersonaRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumnos")
    PersonaRepository alumnoRepository;

    @Autowired
    @Qualifier("empleadoRepository")
    PersonaRepository empleadoRepository;

    @Autowired
    @Qualifier("profesorRepository")
    PersonaRepository profesorRepository;

    @Test
    void buscarPorNombreYApellido() {
        // GIVEN
        Persona save = empleadoRepository.save(DatosDummy.empleado01());

        // WHEN
        Optional<Persona> expected = empleadoRepository.buscarPorNombreYApellido(DatosDummy.empleado01().getNombre(),
                                                        DatosDummy.empleado01().getApellido());

        // THEN
        assertThat(expected.get()).isInstanceOf(Empleado.class);
        assertThat(expected.get()).isEqualTo(save);
    }

    @Test
    void buscarPorDni() {
        // GIVEN
        Persona save = profesorRepository.save(DatosDummy.profesor01());

        // WHEN
        Optional<Persona> expected =  profesorRepository.buscarPorDni(DatosDummy.profesor01().getDni());

        // THEN
        assertThat(expected.get()).isInstanceOf(Profesor.class);
        assertThat(expected.get()).isEqualTo(save);
        assertThat(expected.get().getDni()).isEqualTo(save.getDni());
    }

    @Test
    void buscarPersonasPorApellido() {
        // GIVEN

         Iterable<Persona> personas = alumnoRepository.saveAll(
                                    Arrays.asList(DatosDummy.alumno01(),
                                                DatosDummy.alumno02(),
                                                DatosDummy.alumno03()));
         // WHEN
        String apellido = "Benitez";
        List<Persona> expected = (List<Persona>) alumnoRepository.buscarPersonasPorApellido(apellido);

        // THEN
        assertThat(expected.size()==2).isTrue();
    }
}