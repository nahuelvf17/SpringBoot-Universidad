package com.novando.springsimplespasos.universidadbackend.modelo.mapper.mapstruct;

import com.novando.springsimplespasos.universidadbackend.modelo.dto.AlumnoDTO;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Alumno;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = AlumnoMapperConfig.class)
public abstract class AlumnoMapper {

    public abstract AlumnoDTO mapAlumno(Alumno alumno);
    public abstract Alumno mapAlumno(AlumnoDTO alumnoDTO);

}