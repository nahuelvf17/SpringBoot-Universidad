package com.novando.springsimplespasos.universidadbackend.modelo.mapper.mapstruct;

import com.novando.springsimplespasos.universidadbackend.modelo.dto.PersonaDTO;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Persona;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface PersonaMapperConfig {
    void mapPersona(Persona persona, @MappingTarget PersonaDTO personaDTO);
}
