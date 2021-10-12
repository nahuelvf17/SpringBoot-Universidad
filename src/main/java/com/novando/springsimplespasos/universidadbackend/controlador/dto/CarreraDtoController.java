package com.novando.springsimplespasos.universidadbackend.controlador.dto;

import com.novando.springsimplespasos.universidadbackend.modelo.dto.CarreraDTO;
import com.novando.springsimplespasos.universidadbackend.modelo.dto.GenericDtoController;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Carrera;
import com.novando.springsimplespasos.universidadbackend.modelo.mapper.mapstruct.CarreraMapperMS;
import com.novando.springsimplespasos.universidadbackend.servicios.contratos.CarreraDAO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carreras")
@ConditionalOnProperty(prefix = "app", name="controller.enable-dto", havingValue = "true")
@Api(value="Acciones relacionadas con la Carrera", tags = "Acciones sobre carreras")
public class CarreraDtoController extends GenericDtoController<Carrera, CarreraDAO> {

    @Autowired
    private CarreraMapperMS mapper;


    public CarreraDtoController(CarreraDAO service) {
        super(service, "Carrera");
    }

    @GetMapping
    @ApiOperation(value = "Consultas todas las carreras")
    @ApiResponses({
            @ApiResponse(code=200, message = "Ejecutado Correctamente")
    })
    public ResponseEntity<?> obtenerCarreras(){
        Map<String, Object> mensaje = new HashMap<>();
        List<Carrera> carreras = super.obtenerTodo();

        if(carreras.isEmpty()){
            mensaje.put("success", false);
            mensaje.put("mensaje", String.format("No se encontraron %ss cargadas", nombre_entidad));

            return ResponseEntity.badRequest().body(mensaje);
        }

        List<CarreraDTO> carreraDTOS = carreras
                .stream()
                .map(mapper::mapCarrera)
                .collect(Collectors.toList());

        mensaje.put("success", true);
        mensaje.put("data", carreraDTOS);

        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/id")
    @ApiOperation(value = "Consultar carrera por codigo")
    public ResponseEntity<?> obtenerCarreraPorId(@PathVariable @ApiParam(name = "Codigo del sistema") Integer id){
        return ResponseEntity.ok("");
    }

    @PostMapping
    public ResponseEntity<?> altaCarrera(@RequestBody @ApiParam("Carrera de la universidad") CarreraDTO carreraDTO){
        return ResponseEntity.ok("");
    }

}
