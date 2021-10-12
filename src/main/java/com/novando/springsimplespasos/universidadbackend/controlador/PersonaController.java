package com.novando.springsimplespasos.universidadbackend.controlador;

import com.novando.springsimplespasos.universidadbackend.exception.BadRequestException;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Persona;
import com.novando.springsimplespasos.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Deprecated
public class PersonaController extends GenericController<Persona, PersonaDAO>{
    public PersonaController(PersonaDAO service) {
        super(service);
    }
    @GetMapping("/nombre-apellido")
    public ResponseEntity<?> buscarPersonaPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){
        Map<String, Object> mensaje = new HashMap<>();
        Optional<Persona> oPersona = service.buscarPorNombreYApellido(nombre, apellido);
        if(!oPersona.isPresent()){
            mensaje.put("success", false);
            mensaje.put("mensaje", String.format("No se encontro persona con nombre %s y apellido %s", nombre, apellido));
            return ResponseEntity.badRequest().body(mensaje);
        }

        mensaje.put("success", true);
        mensaje.put("datos", oPersona.get());

        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/por-dni")
    public Persona buscarPersonaPorDni(@RequestParam String dni){
        Optional<Persona> oPersona = service.buscarPorDni(dni);

        return oPersona.orElseThrow(()->new BadRequestException(String.format("No se encontro persona con DNI : %s", dni)));
    }

    @GetMapping("/apellido")
    public List<Persona> buscarPersonaPorApellido(@RequestParam String apellido){
        List<Persona> personas = (List<Persona>) service.BuscarPersonasPorApellido(apellido);

        if(personas.isEmpty()){
            throw new BadRequestException(String.format("No existen personas con el apellido %s", apellido));
        }

        return personas;
    }
}
