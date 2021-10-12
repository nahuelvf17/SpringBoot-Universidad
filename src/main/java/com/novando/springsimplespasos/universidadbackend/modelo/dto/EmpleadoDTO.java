package com.novando.springsimplespasos.universidadbackend.modelo.dto;

import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Direccion;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class EmpleadoDTO extends PersonaDTO {
    private BigDecimal sueldo;
    private TipoEmpleado tipoEmpleado;

    public EmpleadoDTO(Integer id, String nombre, String apellido, String dni, Direccion direccion, BigDecimal sueldo, TipoEmpleado tipoEmpleado) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
        this.tipoEmpleado = tipoEmpleado;
    }
}
