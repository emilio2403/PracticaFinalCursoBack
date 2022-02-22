package application.controller;

import application.dto.InfraestructuraDTO;
import application.mapper.InfraestructuraMapper;
import application.model.Infraestructura;
import application.repository.InfraestructuraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/infraestructura")
@RequiredArgsConstructor
public class InfraestructuraController {

    private final InfraestructuraRepository repository;
    private final InfraestructuraMapper mapper;

    @GetMapping("/all")
    public ResponseEntity<List<InfraestructuraDTO>> getAllInfraestructura() {
        Optional<List<InfraestructuraDTO>> estructuras = Optional.of(mapper.toDTOList(repository.findAll()));
        if (estructuras.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(estructuras.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfraestructuraDTO> getInfraestructuraById(@RequestParam(name = "id",required = true) long id){
        Optional<Infraestructura> estructura = repository.findById(id);
        if(estructura.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(estructura.get()));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{tipo}")
    public ResponseEntity<List<InfraestructuraDTO>> getInfraestructuraByTipo(@RequestParam(name = "tipo",required = true) String tipo){
        Optional<List<Infraestructura>> estructura = repository.findAllByTipo(tipo);
        if(estructura.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTOList(estructura.get()));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/post")
    public ResponseEntity<InfraestructuraDTO> postInfraestructura(@RequestBody InfraestructuraDTO infraestructura) {
        Optional<InfraestructuraDTO> estructura = Optional.of(mapper.toDTO(repository.insert(mapper.toModel(infraestructura))));
        if (estructura.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(estructura.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Long> deleteInfraestructura(@RequestBody long id) {
        repository.deleteById(id);
        Optional<Infraestructura> estructura = repository.findById(id);
        if (estructura.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<InfraestructuraDTO> updateInfaestructura(@RequestBody InfraestructuraDTO infraestructura){
        Optional<InfraestructuraDTO> estructura = Optional.of(mapper.toDTO(repository.save(mapper.toModel(infraestructura))));
        if(estructura.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(estructura.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
