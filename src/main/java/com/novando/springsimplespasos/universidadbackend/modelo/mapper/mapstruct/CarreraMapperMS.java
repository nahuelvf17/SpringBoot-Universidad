package com.novando.springsimplespasos.universidadbackend.modelo.mapper.mapstruct;

import com.novando.springsimplespasos.universidadbackend.modelo.dto.CarreraDTO;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Carrera;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CarreraMapperMS {
    @Mappings({
            @Mapping(source = "id", target = "codigo"),
            @Mapping(source = "cantidaMaterias ", target = "cantidad_materias"),
            @Mapping(source = "cantidadAnios", target = "cantidad_anios"),
    })
    CarreraDTO mapCarrera(Carrera carrera);
}
