package com.novando.springsimplespasos.universidadbackend.modelo.dto;

import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Direccion;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class AlumnoDTO extends PersonaDTO {
    public AlumnoDTO(Integer id, String nombre, String apellido, String dni, Direccion direccion) {
        super(id, nombre, apellido, dni, direccion);
    }
}
