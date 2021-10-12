package com.novando.springsimplespasos.universidadbackend.controlador.dto;

import com.novando.springsimplespasos.universidadbackend.modelo.dto.GenericDtoController;
import com.novando.springsimplespasos.universidadbackend.modelo.dto.PersonaDTO;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Alumno;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Empleado;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Persona;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Profesor;
import com.novando.springsimplespasos.universidadbackend.modelo.mapper.mapstruct.AlumnoMapper;
import com.novando.springsimplespasos.universidadbackend.servicios.contratos.PersonaDAO;


public class PersonaDtoController extends GenericDtoController<Persona, PersonaDAO> {

    protected final AlumnoMapper alumnoMapper;

    public PersonaDtoController(PersonaDAO service, String nombre_entidad, AlumnoMapper alumnoMapper) {
        super(service, nombre_entidad);
        this.alumnoMapper = alumnoMapper;
    }

    public PersonaDTO altaPersona(Persona persona){
        Persona personaEntidad = super.altaEntidad(persona);
        PersonaDTO dto = null;

        if(personaEntidad instanceof Alumno){
            dto = alumnoMapper.mapAlumno((Alumno) personaEntidad);
        }else if( personaEntidad instanceof Profesor ) {
            // aplicamos mapper profesor
        } else if( personaEntidad instanceof Empleado){
            // aplicamos mapper empleado
        }
        return dto;
    }
}
