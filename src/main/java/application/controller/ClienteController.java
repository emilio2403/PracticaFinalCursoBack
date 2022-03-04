package application.controller;

import application.dto.ClienteDTO;
import application.error.GeneralError;
import application.mapper.ClienteMapper;
import application.model.Cliente;
import application.repository.ClienteRepository;
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
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper mapper;


    @ApiOperation(value = "Get All Cliente", notes = "Devuelve una lista de clientes.")
    @ApiResponse(code = 200, message = "OK", response = ClienteDTO.class)
    @GetMapping("/")
    public ResponseEntity<List<ClienteDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(mapper.toDTOList(clienteRepository.findAll()));
    }

    @ApiOperation(value = "Get Cliente By Id", notes = "Devolverá el cliente en caso de encontrarlo.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ClienteDTO.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = GeneralError.class)
    })
    @GetMapping("/{id}")
    public ResponseEntity findById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(cliente.get()));
        }
    }

    @ApiOperation(value = "Get Cliente By Correo", notes = "Devolverá el cliente en caso de encontrarlo.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ClienteDTO.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = GeneralError.class)
    })
    @GetMapping("/{correo}")
    public ResponseEntity getByEmail(@RequestParam(name = "tipo", required = true) String correo) {
        Optional<Cliente> cliente = clienteRepository.findByCorreo(correo);
        if (cliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(cliente.get()));
        }
    }

    @ApiOperation(value = "Post Cliente", notes = "Devuelve el cliente que se ha insertado.")
    @ApiResponse(code = 201, message = "Created", response = ClienteDTO.class)
    @PostMapping("/")
    public ResponseEntity<ClienteDTO> postClient(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(clienteRepository.insert(mapper.toModel(clienteDTO))));
    }

    @ApiOperation(value = "Put Cliente", notes = "Devuelve el cliente que ha sido modificado.")
    @ApiResponse(code = 200, message = "OK", response = ClienteDTO.class)
    @PutMapping("/")
    public ResponseEntity<ClienteDTO> putClient(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(clienteRepository.save(mapper.toModel(clienteDTO))));
    }

    @ApiOperation(value = "Delete Cliente", notes = "Devolverá una respuesta sin cuerpo.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content", response = ClienteDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralError.class)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@RequestParam(name = "id", required = true) UUID id) {
        clienteRepository.deleteById(id);
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        }
    }


}
