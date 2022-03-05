package application.controller;

import application.configuration.views.Views;
import application.dto.AlquilerDTO;
import application.error.GeneralError;
import application.mapper.AlquilerMapper;
import application.model.Alquiler;
import application.repository.AlquilerRepository;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/alquiler")
@RequiredArgsConstructor
public class AlquilerController {

    private final AlquilerRepository alquilerRepository;
    private final AlquilerMapper alquilerMapper;

    @ApiOperation(value = "Get All Alquileres", notes = "Devuelve una lista de alquileres.")
    @ApiResponse(code = 200, message = "OK", response = AlquilerDTO.class)
    @JsonView(Views.Alquiler.class)
    @GetMapping(value = "/all")
    public ResponseEntity<List<AlquilerDTO>> getAllAlquileres() {
        return ResponseEntity.status(HttpStatus.OK).body(alquilerMapper.toDTOList(alquilerRepository.findAll()));
    }

    @ApiOperation(value = "Get Alquiler By Id", notes = "Devolverá el alquiler en caso de encontrarlo.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = AlquilerDTO.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = GeneralError.class)
    })
    @JsonView(Views.Alquiler.class)
    @GetMapping("/{id}")
    public ResponseEntity getAlquilerById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Alquiler> alquiler = alquilerRepository.findById(id);
        if (alquiler.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(alquilerMapper.toDTO(alquiler.get()));
        }
    }

    @ApiOperation(value = "Get Alquiler By Cliente Id", notes = "Devolverá el alquiler en caso de encontrarlo.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = AlquilerDTO.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = GeneralError.class)
    })
    @JsonView(Views.Alquiler.class)
    @GetMapping("/{id}/alquiler")
    public ResponseEntity getAlquilerByClienteId(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Alquiler> alquiler = alquilerRepository.getAlquilerByCliente_Id(id);
        if (alquiler.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(alquilerMapper.toDTO(alquiler.get()));
        }
    }

    @ApiOperation(value = "Post Alquiler", notes = "Devuelve el alquiler que se ha insertado.")
    @ApiResponse(code = 201, message = "Created", response = AlquilerDTO.class)
    @JsonView(Views.Alquiler.class)
    @PostMapping("/post")
    public ResponseEntity<AlquilerDTO> postAlquiler(@RequestBody AlquilerDTO alquilerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alquilerMapper.toDTO(alquilerRepository.insert(alquilerMapper.toModel(alquilerDTO))));
    }

    @ApiOperation(value = "Delete Alquiler", notes = "Devolverá una respuesta sin cuerpo.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content", response = AlquilerDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralError.class)
    })
    @JsonView(Views.Alquiler.class)
    @DeleteMapping("/delete")
    public ResponseEntity deleteAlquiler(@RequestParam(name = "id", required = true) UUID id) {
        alquilerRepository.deleteById(id);
        Optional<Alquiler> alquiler = alquilerRepository.findById(id);
        if (alquiler.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        }
    }

    @ApiOperation(value = "Put Alquiler", notes = "Devuelve el alquiler que ha sido modificado.")
    @ApiResponse(code = 200, message = "OK", response = AlquilerDTO.class)
    @JsonView(Views.Alquiler.class)
    @PutMapping("/update")
    public ResponseEntity<AlquilerDTO> updateAlquiler(@RequestBody AlquilerDTO alquilerDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(alquilerMapper.toDTO(alquilerRepository.save(alquilerMapper.toModel(alquilerDTO))));
    }
}
