package application.controller;

import application.configuration.views.Views;
import application.dto.ClienteDTO;
import application.dto.InfraestructuraDTO;
import application.error.GeneralError;
import application.mapper.ClienteMapper;
import application.model.Cliente;
import application.model.Login;
import application.repository.ClienteRepository;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper mapper;

    @ApiOperation(value = "Login cliente", notes = "Login del cliente android.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = InfraestructuraDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralError.class)
    })
    @GetMapping("/login")
    public ResponseEntity login(@RequestParam(required = false, name = "token") Optional<String> token,
                                @RequestParam(name = "mail") String mail,
                                @RequestParam(name = "password") String password) {
        if (token.isPresent()) {
            return findUser(mail, password, token);
        } else {
            return findUser(mail, password, Optional.empty());
        }
    }

    /**
     * Método que comprueba el login
     *
     * @param mail     String correo
     * @param password String password
     * @param token    Optional<String> token
     * @return ResponseEntity respuesta
     */
    private ResponseEntity findUser(String mail, String password, Optional<String> token) {
        Optional<Cliente> cliente = clienteRepository.findByCorreo(mail);
        if (cliente.isPresent() &&
                cliente.get().getPassword().equals(password) &&
                cliente.get().getCorreo().equals(mail)) {
            if (token.isEmpty()) {
                if (cliente.get().getLogin() != null) {
                    return ResponseEntity.ok(mapper.toDTO(cliente.get()));
                }
                LocalDateTime fecha = LocalDateTime.now();
                fecha.plusMonths(1);
                cliente.get().setLogin(new Login(fecha, UUID.randomUUID()));
                clienteRepository.save(cliente.get());
                return ResponseEntity.ok(mapper.toDTO(cliente.get()));
            }
            if (cliente.get().getLogin().getFecha().isBefore(LocalDateTime.now()) &&
                    cliente.get().getLogin().getToken().equals(UUID.fromString(token.get()))) {
                return ResponseEntity.ok(mapper.toDTO(cliente.get()));
            }
            if (cliente.get().getLogin().getFecha().isAfter(LocalDateTime.now())) {
                LocalDateTime fecha = LocalDateTime.now();
                fecha.plusMonths(1);
                cliente.get().getLogin().setFecha(fecha);
                cliente.get().getLogin().setToken(UUID.randomUUID());
                clienteRepository.save(cliente.get());
                return ResponseEntity.ok(mapper.toDTO(cliente.get()));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
    }

    @ApiOperation(value = "Get All Cliente", notes = "Devuelve una lista de clientes.")
    @ApiResponse(code = 200, message = "OK", response = ClienteDTO.class)
    @GetMapping("/all")
    public ResponseEntity<List<ClienteDTO>> findAll() {
        return ResponseEntity.ok(mapper.toDTOList(clienteRepository.findAll()));
    }

    @ApiOperation(value = "Get Cliente By Id", notes = "Devolverá el cliente en caso de encontrarlo.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ClienteDTO.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = GeneralError.class)
    })
    @GetMapping("/id")
    public ResponseEntity findById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(cliente.get()));
        }
    }

    @ApiOperation(value = "Post Cliente", notes = "Devuelve el cliente que se ha insertado.")
    @ApiResponse(code = 201, message = "Created", response = ClienteDTO.class)
    @JsonView(Views.Cliente.class)
    @PostMapping("/post")
    public ResponseEntity<ClienteDTO> postClient(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(clienteRepository.insert(mapper.toModel(clienteDTO))));
    }

    @ApiOperation(value = "Put Cliente", notes = "Devuelve el cliente que ha sido modificado.")
    @ApiResponse(code = 200, message = "OK", response = ClienteDTO.class)
    @PutMapping("/put")
    public ResponseEntity<ClienteDTO> putClient(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(clienteRepository.save(mapper.toModel(clienteDTO))));
    }

    @ApiOperation(value = "Delete Cliente", notes = "Devolverá una respuesta sin cuerpo.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content", response = ClienteDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralError.class)
    })
    @JsonView(Views.Cliente.class)
    @DeleteMapping("/delete")
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
