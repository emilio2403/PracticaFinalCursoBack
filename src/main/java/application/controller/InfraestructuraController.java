package application.controller;

import application.configuration.views.Views;
import application.dto.InfraestructuraDTO;
import application.error.GeneralError;
import application.mapper.InfraestructuraMapper;
import application.model.Alquiler;
import application.model.Infraestructura;
import application.repository.InfraestructuraRepository;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/infraestructura")
@RequiredArgsConstructor
public class InfraestructuraController {

    private final InfraestructuraRepository repository;
    private final InfraestructuraMapper mapper;

    @ApiOperation(value = "Get All Infraestructuras", notes = "Devuelve una lista de infraestructuras.")
    @ApiResponse(code = 200, message = "OK", response = InfraestructuraDTO.class)
    @GetMapping("/all")
    public ResponseEntity<List<InfraestructuraDTO>> getAllInfraestructura() {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTOList(repository.findAll()));
    }

    @ApiOperation(value = "Get Infraestructura By Id", notes = "Devolverá la infraestructura en caso de encontrarla.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = InfraestructuraDTO.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = GeneralError.class)
    })
    @JsonView(Views.Infraestructura.class)
    @GetMapping("/id")
    public ResponseEntity getInfraestructuraById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Infraestructura> estructura = repository.findById(id);
        if (estructura.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(estructura.get()));
        }
    }

    @ApiOperation(value = "Get Infraestructura By Tipo", notes = "Devolverá la infraestructura en caso de encontrarla.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = InfraestructuraDTO.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = GeneralError.class)
    })
    @GetMapping("/tipo")
    public ResponseEntity getInfraestructuraByTipo(@RequestParam(name = "tipo", required = true) String tipo) {
        Optional<List<Infraestructura>> estructura = repository.findAllByTipo(tipo);
        if (estructura.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        } else {
            return ResponseEntity.ok(mapper.toDTOList(estructura.get()));
        }
    }

    @ApiOperation(value = "Post Infraestructura", notes = "Devuelve la infraestructura que se ha insertado.")
    @ApiResponse(code = 201, message = "Created", response = InfraestructuraDTO.class)
    @JsonView(Views.Infraestructura.class)
    @PostMapping("/post")
    public ResponseEntity<InfraestructuraDTO> postInfraestructura(@RequestBody InfraestructuraDTO infraestructura) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(repository.save(mapper.toModel(infraestructura))));
    }

    @ApiOperation(value = "Delete Infraestructura", notes = "Devolverá una respuesta sin cuerpo.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content", response = InfraestructuraDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralError.class)
    })
    @JsonView(Views.Infraestructura.class)
    @DeleteMapping("/delete")
    public ResponseEntity deleteInfraestructura(@RequestParam(name = "id", required = true) UUID id) {
        repository.deleteById(id);
        Optional<Infraestructura> estructura = repository.findById(id);
        if (estructura.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        }
    }

    @ApiOperation(value = "Put Infraestructura", notes = "Devuelve la infraestructura que ha sido modificada.")
    @ApiResponse(code = 200, message = "OK", response = InfraestructuraDTO.class)
    @JsonView(Views.Infraestructura.class)
    @PutMapping("/update")
    public ResponseEntity<InfraestructuraDTO> updateInfaestructura(@RequestBody InfraestructuraDTO infraestructura) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(repository.save(mapper.toModel(infraestructura))));
    }

    @ApiOperation(value = "Get horas libres", notes = "Devuelve las horas libres de una dia y de una pista.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = InfraestructuraDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralError.class)
    })
    @GetMapping("/libres")
    public ResponseEntity getHorasLibres(@RequestParam(name = "id") UUID id,
                                         @RequestParam(name = "year") Integer year,
                                         @RequestParam(name = "month") Integer month,
                                         @RequestParam(name = "day") Integer day) {
        Optional<Infraestructura> infraestructura = repository.findById(id);
        if (infraestructura.isPresent()) {
            List<Alquiler> alquileresDia = infraestructura.get().getAlquileres().stream().filter((v) ->
                    v.getDay() == day && v.getMonth() == month && v.getYear() == year).collect(Collectors.toList());
            List<Integer> horas = new ArrayList();
            for (int i = infraestructura.get().getApertura(); i < infraestructura.get().getCierre(); i++) {
                boolean existe = false;
                int cont = 0;
                while (cont < alquileresDia.size() && !existe) {
                    if (alquileresDia.get(cont).getInicio() == i) {
                        existe = true;
                    }
                    cont++;
                }
                if (!existe) {
                    horas.add(i);
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body(horas);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        }
    }
}
