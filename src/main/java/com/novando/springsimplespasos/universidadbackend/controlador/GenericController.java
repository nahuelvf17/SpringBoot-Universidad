package com.novando.springsimplespasos.universidadbackend.controlador;

import com.novando.springsimplespasos.universidadbackend.exception.BadRequestException;
import com.novando.springsimplespasos.universidadbackend.servicios.contratos.GenericoDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Deprecated
public class GenericController <E, S extends GenericoDAO<E>> {
    protected final S service;
    protected String nombreEntidad;

    public GenericController(S service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        Map<String, Object> mensaje = new HashMap<>();
        List<E> listado = (List<E>) service.findAll();
        if(listado.isEmpty()){
            //throw new BadRequestException(String.format("No se han encontrado %ss", nombreEntidad));
            mensaje.put("success", false);
            mensaje.put("mensaje", String.format("No existen %ss", nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }
        mensaje.put("success", true);
        mensaje.put("datos", listado);
        return ResponseEntity.ok().body(mensaje);
    }
    /*
    @GetMapping("/{id}")
    public E obtenerPorId(@PathVariable(required = false) Integer id){
        Optional<E> oAlumno = service.findById(id);
        return oAlumno.orElseThrow(()->new BadRequestException(String.format(" %s con id : %d no existe", nombreEntidad,id)));
    }

    @PostMapping
    public E altaDeEntidad(@RequestBody E entidad){
        return service.save(entidad);
    }
*/
    @DeleteMapping("/{id}")
    public void borrarPorId(@PathVariable Integer id){
        service.deleteById(id);
    }
}
