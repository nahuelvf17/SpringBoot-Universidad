package com.novando.springsimplespasos.universidadbackend.controlador.dto;

import com.novando.springsimplespasos.universidadbackend.modelo.dto.AlumnoDTO;
import com.novando.springsimplespasos.universidadbackend.modelo.dto.PersonaDTO;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Alumno;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Persona;
import com.novando.springsimplespasos.universidadbackend.modelo.mapper.mapstruct.AlumnoMapper;
import com.novando.springsimplespasos.universidadbackend.servicios.contratos.PersonaDAO;
import com.novando.springsimplespasos.universidadbackend.servicios.implementaciones.AlumnoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
@ConditionalOnProperty(prefix = "app", name="controller.enable-dto", havingValue = "true")
public class AlumnoDtoController extends PersonaDtoController{

    public AlumnoDtoController(PersonaDAO service, AlumnoMapper alumnoMapper) {
        super(service, "Alumno", alumnoMapper);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable(required = false) Integer id){
        Map<String, Object> mensaje = new HashMap<>();
        //Optional<Persona> oPersona = personaDAO.findById(id);

        //PersonaDTO dto = mapper.mapAlumno((Alumno) oPersona.get());

        mensaje.put("success", true);
        //mensaje.put("data", dto);

        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> altaAlumno(@Valid @RequestBody PersonaDTO personaDTO, BindingResult result){
        Map<String, Object> mensaje = new HashMap<>();
        if(result.hasErrors()){
            mensaje.put("success", false);
            mensaje.put("validaciones", super.obtenerValidaciones(result));

            return ResponseEntity.badRequest().body(mensaje);
        }

        PersonaDTO personaSave = super.altaPersona(alumnoMapper.mapAlumno((AlumnoDTO) personaDTO));

        mensaje.put("success", true);
        mensaje.put("data", personaSave);

        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }
}
