package application.controller;

import application.dto.AlquilerDTO;
import application.error.GeneralError;
import application.mapper.AlquilerMapper;
import application.model.Alquiler;
import application.repository.AlquilerRepository;
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

    @GetMapping(value = "/all")
    public ResponseEntity<List<AlquilerDTO>> getAllAlquileres() {
        return ResponseEntity.status(HttpStatus.OK).body(alquilerMapper.toDTOList(alquilerRepository.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getAlquilerById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Alquiler> alquiler = alquilerRepository.findById(id);
        if (alquiler.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(alquilerMapper.toDTO(alquiler.get()));
        }
    }

    @GetMapping("/{id}/alquiler")
    public ResponseEntity getAlquilerByClienteId(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Alquiler> alquilerById = alquilerRepository.getAlquilerByCliente_Id(id);
        if (alquilerById.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(alquilerMapper.toDTO(alquilerById.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GeneralError());
        }
    }

    @PostMapping("/post")
    public ResponseEntity<AlquilerDTO> postAlquiler(@RequestBody AlquilerDTO alquilerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alquilerMapper.toDTO(alquilerRepository.insert(alquilerMapper.toModel(alquilerDTO))));
    }

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

    @PutMapping("/update")
    public ResponseEntity<AlquilerDTO> updateAlquiler(@RequestBody AlquilerDTO alquilerDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(alquilerMapper.toDTO(alquilerRepository.save(alquilerMapper.toModel(alquilerDTO))));
    }
}
