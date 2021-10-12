package com.novando.springsimplespasos.universidadbackend.controlador;

import com.novando.springsimplespasos.universidadbackend.exception.BadRequestException;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Carrera;
import com.novando.springsimplespasos.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Deprecated
@RestController
@RequestMapping("/carreras")
@ConditionalOnProperty(prefix = "app", name="controller.enable-dto", havingValue = "false")
public class CarreraController extends GenericController<Carrera, CarreraDAO> {

    @Autowired
    public CarreraController(CarreraDAO service){
        super(service);
        nombreEntidad="Carrera";
    }
/*
    @GetMapping("/{codigo}")
    public Carrera obtenerPorId(@PathVariable(value = "codigo", required = false) Integer id) {
        Optional<Carrera> oCarrera = service.findById(id);

        return oCarrera.orElseThrow(()->new BadRequestException(String.format("La carrera con id : %d no existe", id)));
    }
*/
    @PostMapping
    public ResponseEntity<?> altaCarrera(@Valid @RequestBody Carrera carrera, BindingResult result){
        /*
        if(carrera.getCantidadAnios() < 0){
            throw new BadRequestException("El campo cantidad años debe ser mayor a cero");
        }

        if(carrera.getCantidaMaterias() < 0){
            throw new BadRequestException("El campo cantidad materias debe ser mayor a cero");
        }
        */

        Map<String, Object> validaciones = new HashMap<>();
        if(result.hasErrors()){
            result.getFieldErrors().forEach(error->{
                validaciones.put(error.getField(), error.getDefaultMessage());
            });

            return ResponseEntity.badRequest().body(validaciones);
        }

        return ResponseEntity.ok(service.save(carrera));
    }
/*
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera){
        Map<String, Object> mensaje = new HashMap<>();
        Carrera carreraUpdate=null;
        Optional<Carrera> oCarrera = service.findById(id);

        if(!oCarrera.isPresent()){
            //throw new BadRequestException(String.format("La carrera con id : %d no existe", id));
            mensaje.put("success", false);
            mensaje.put("mensaje", String.format("La carrera con id : %d no existe", id));

            return ResponseEntity.badRequest().body(mensaje);
        }

        carreraUpdate = oCarrera.get();
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidaMaterias(carrera.getCantidaMaterias());

        mensaje.put("success", true);
        mensaje.put("datos", service.save(carreraUpdate));
        return ResponseEntity.ok().body(mensaje);
    }
/*
    @DeleteMapping("/{id}")
    public void eliminarCarrera(@PathVariable Integer id){
        service.deleteById(id);
    }

*/
}
