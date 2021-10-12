package com.novando.springsimplespasos.universidadbackend.modelo.dto;

import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Direccion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProfesorDTO extends PersonaDTO {
    private BigDecimal sueldo;

    public ProfesorDTO(Integer id, String nombre, String apellido, String dni, Direccion direccion, BigDecimal sueldo) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
    }
}
