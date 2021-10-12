package com.novando.springsimplespasos.universidadbackend.modelo.dto;

import com.novando.springsimplespasos.universidadbackend.servicios.contratos.GenericoDAO;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class GenericDtoController <E, S extends GenericoDAO<E>>{
    protected final S service;
    protected final String nombre_entidad;

    public List<E> obtenerTodo(){
        return (List<E>) service.findAll();
    }

    public E obtenerPorId(Integer id){
        return (E) service.findById(id);
    }

    public E altaEntidad(E entidad){
        return (E) service.save(entidad);
    }

    protected Map<String, Object> obtenerValidaciones(BindingResult result){
        Map<String, Object> validaciones = new HashMap<>();
        result.getFieldErrors()
                .forEach(error-> validaciones.put(error.getField(), error.getDefaultMessage()));

        return validaciones;
    }
}
