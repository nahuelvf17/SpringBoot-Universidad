package com.novando.springsimplespasos.universidadbackend.modelo.mapper.mapstruct;

import com.novando.springsimplespasos.universidadbackend.modelo.dto.AlumnoDTO;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Alumno;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface AlumnoMapperConfig extends PersonaMapperConfig{

    @InheritConfiguration(name = "mapPersona")
    void mapAlumno (Alumno alumno, @MappingTarget AlumnoDTO alumnoDTO);

}