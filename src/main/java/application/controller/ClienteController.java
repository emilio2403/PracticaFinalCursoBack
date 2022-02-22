package application.controller;

import application.dto.ClienteDTO;
import application.mapper.ClienteMapper;
import application.model.Cliente;
import application.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper mapper;


    @GetMapping("/")
    public ResponseEntity<List<ClienteDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(mapper.toDTOList(clienteRepository.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(mapper.toDTO(clienteRepository.findById(id).orElseThrow()));
    }

    @GetMapping("/{correo}")
    public ResponseEntity<ClienteDTO> getByEmail(@PathVariable String correo) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(mapper.toDTO(clienteRepository.findByCorreo(correo).orElseThrow()));
    }


    @PostMapping("/")
    public ResponseEntity<ClienteDTO> postClient(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toDTO(clienteRepository.insert(mapper.toModel(clienteDTO))));
    }

    @PutMapping("/")
    public ResponseEntity<ClienteDTO> putClient(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toDTO(clienteRepository.save(mapper.toModel(clienteDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteDTO> delete(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            clienteRepository.delete(cliente);
            return ResponseEntity.ok(mapper.toDTO(cliente));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ClienteDTO());
    }


}
