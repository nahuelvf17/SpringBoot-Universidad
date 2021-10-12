package com.novando.springsimplespasos.universidadbackend.controlador;

import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Alumno;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Carrera;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Persona;
import com.novando.springsimplespasos.universidadbackend.servicios.contratos.CarreraDAO;
import com.novando.springsimplespasos.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Deprecated
@RestController
@RequestMapping("/alumnos")
@ConditionalOnProperty(prefix = "app", name="controller.enable-dto", havingValue = "true")
public class AlumnoController extends PersonaController{

    private final CarreraDAO carreraDao;

    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDao, CarreraDAO carreraDAO) {
        super(alumnoDao);
        nombreEntidad="Alumno";
        this.carreraDao= carreraDAO;
    }
/*
    @GetMapping
    public List<Persona> obtenerTodos(){
        List<Persona> alumnos = (List<Persona>) service.findAll();

        if(alumnos.isEmpty()){
            throw new BadRequestException("No existen alumnos");
        }

        return alumnos;
    }

    @GetMapping("/{id}")
    public Persona obtenerAlumnoPorId(@PathVariable(required = false) Integer id){
        Optional<Persona> oAlumno = service.findById(id);
        return oAlumno.orElseThrow(()->new BadRequestException(String.format("El alumno con id : %d no existe", id)));
    }

    @PostMapping
    public Persona altaAlumno(@RequestBody Persona alumno){
        return service.save(alumno);
    }
*/
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAlumno(@PathVariable Integer id, @RequestBody Persona alumno){
        Map<String, Object> mensaje = new HashMap<>();
        Persona alumnoUpdate=null;

        Optional<Persona> oAlumno = service.findById(id);

        if(!oAlumno.isPresent()){
            mensaje.put("success", false);
            mensaje.put("mensaje", String.format("El alumno con id : %d no existe", id));

            return ResponseEntity.badRequest().body(mensaje);
        }

        alumnoUpdate = oAlumno.get();
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setDni(alumno.getDni());

        mensaje.put("success", true);
        mensaje.put("datos", alumnoUpdate);

        return ResponseEntity.ok(mensaje);

    }
/*
    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Integer id){
        service.deleteById(id);
    }
*/
    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public ResponseEntity<?> asignarCarrera(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Map<String, Object> mensaje = new HashMap<>();

        Optional<Persona> oAlumno = service.findById(idAlumno);
        if(!oAlumno.isPresent()){
            mensaje.put("success", false);
            mensaje.put("mensaje", String.format("El alumno con id : %d no existe", idAlumno));
            return ResponseEntity.badRequest().body(mensaje);
        }

        Optional<Carrera> oCarrera = carreraDao.findById(idCarrera);
        if(!oCarrera.isPresent()){
            mensaje.put("success", false);
            mensaje.put("mensaje", String.format("La carrera con id : %d no existe", idCarrera));
            return ResponseEntity.badRequest().body(mensaje);
        }

        Persona alumno = oAlumno.get();
        Carrera carrera = oCarrera.get();
        ((Alumno)alumno).setCarrera(carrera);

        mensaje.put("success", true);
        mensaje.put("datos", service.save(alumno));

        return ResponseEntity.ok(mensaje);
    }
}
