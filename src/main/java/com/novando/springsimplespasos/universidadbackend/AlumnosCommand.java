package com.novando.springsimplespasos.universidadbackend;

import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Alumno;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Carrera;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Persona;
import com.novando.springsimplespasos.universidadbackend.servicios.contratos.AlumnoDAO;
import com.novando.springsimplespasos.universidadbackend.servicios.contratos.CarreraDAO;
import com.novando.springsimplespasos.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlumnosCommand implements CommandLineRunner {

    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDAO;

    @Autowired
    private CarreraDAO carreraDAO;

    @Override
    public void run(String... args) throws Exception {
        /*
        Optional<Carrera> ingSistemas = carreraDAO.findById(2);

        Iterable<Persona> alumnos = personaDAO.findAll();
        alumnos.forEach(alumno->((Alumno)alumno).setCarrera(ingSistemas.get()));
        alumnos.forEach(alumno -> personaDAO.save(alumno));
        */

/*
        Optional<Persona> personaNomApe = personaDAO.buscarPorNombreYApellido(alumno1.get().getNombre(), alumno1.get().getApellido());

        System.out.println(personaNomApe.toString());

        Optional<Persona> personaDni = personaDAO.buscarPorDni(alumno1.get().getDni());
        System.out.println(personaDni.toString());

        Iterable<Persona> personasApellido = personaDAO.BuscarPersonasPorApellido(alumno1.get().getApellido());
        personasApellido.forEach(System.out::println);
*/
        /*
        Optional<Persona> alumno1 = personaDAO.findById(1);
        Optional<Carrera> ingSistemas = carreraDAO.findById(2);
        Iterable<Persona> alumnosCarrera = ((AlumnoDAO)personaDAO).buscarAlumnosPorNombreCarrera(ingSistemas.get().getNombre());
        alumnosCarrera.forEach(System.out::println); */
    }
}
