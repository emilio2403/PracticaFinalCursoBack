package application.controller;

import application.dto.AlquilerDTO;
import application.mapper.AlquilerMapper;
import application.model.Alquiler;
import application.repository.AlquilerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alquiler")
@RequiredArgsConstructor
public class AlquilerControler {

    private final AlquilerRepository alquilerRepository;
    private final AlquilerMapper alquilerMapper;

    @GetMapping("/all")
    public ResponseEntity<List<AlquilerDTO>> getAllAlquileres() {
        Optional<List<Alquiler>> alquileres = Optional.of(alquilerRepository.findAll());
        if (alquileres.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(alquilerMapper.toDTOList(alquileres.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<AlquilerDTO>> getAlquilerByClienteId(@RequestParam(name = "id", required = true) long id) {
        Optional<List<Alquiler>> alquilerById = alquilerRepository.getAlquilerByCliente_Id(id);
        if (alquilerById.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(alquilerMapper.toDTOList(alquilerById.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/post")
    public ResponseEntity<AlquilerDTO> postAlquiler(@RequestBody AlquilerDTO alquilerDTO) {
        Optional<Alquiler> alquilerPost = Optional.of(alquilerRepository.insert(alquilerMapper.toModel(alquilerDTO)));
        if (alquilerPost.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(alquilerMapper.toDTO(alquilerPost.get()));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Long> deleteAlquiler(@RequestParam(name = "id", required = true) long id) {
        alquilerRepository.deleteById(id);
        Optional<Alquiler> alquiler = alquilerRepository.findById(id);
        if (alquiler.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<AlquilerDTO> updateAlquiler(@RequestBody AlquilerDTO alquilerDTO) {
        Optional<Alquiler> alquilerPut = Optional.of(alquilerRepository.save(alquilerMapper.toModel(alquilerDTO)));
        if (alquilerPut.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(alquilerMapper.toDTO(alquilerPut.get()));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
