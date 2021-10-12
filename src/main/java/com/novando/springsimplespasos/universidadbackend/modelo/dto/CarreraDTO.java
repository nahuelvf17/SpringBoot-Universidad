package com.novando.springsimplespasos.universidadbackend.modelo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Carrera de la universidad", value = "Carrera", reference = "Carrera")
public class CarreraDTO {

    @ApiModelProperty(name = "Codigo del sistema", example = "5")
    private Integer codigo;
    @NotNull
    @NotEmpty(message = "Debe ingresar un valor")
    @Size(min = 0, max=80)
    @Column(nullable = false, unique = true, length = 80)
    @ApiModelProperty(name = "Nombre de la carrera", example = "Lic. en Alimentos", required = true)
    private String nombre;
    @Positive(message = "El valor no puede ser negativo")
    @ApiModelProperty(notes = "Cantidad materias de toda la carrera", example = "55", required = true)
    private Integer cantidad_materias;
    @Positive(message = "La cantidad de años no puede ser negativa")
    @ApiModelProperty(notes = "Cantidad de años de duracion de la carrera", example = "5", required = true)
    private Integer cantidad_anios;
}
