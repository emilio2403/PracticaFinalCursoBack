package application.controller;

import application.dto.AdminDTO;
import application.error.GeneralError;
import application.mapper.AdminMapper;
import application.model.Admin;
import application.repository.AdminRepository;
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
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminRepository repository;
    private final AdminMapper mapper;

    @ApiOperation(value = "Get All Admin", notes = "Devuelve una lista de administradores.")
    @ApiResponse(code = 200, message = "OK", response = AdminDTO.class)
    @GetMapping("/all")
    public ResponseEntity<List<AdminDTO>> getAllAdmin() {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTOList(repository.findAll()));
    }

    @ApiOperation(value = "Get Admin By Id", notes = "Devolverá el administrador en caso de encontrarlo.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = AdminDTO.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = GeneralError.class)
    })
    @GetMapping("/id")
    public ResponseEntity getAdminById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Admin> admin = repository.findById(id);
        if (admin.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(admin.get()));
        }
    }

    @ApiOperation(value = "Post Admin", notes = "Devuelve el administrador que se ha insertado.")
    @ApiResponse(code = 201, message = "Created", response = AdminDTO.class)
    @PostMapping("/post")
    public ResponseEntity<AdminDTO> postAdmin(@RequestBody AdminDTO admin) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(repository.insert(mapper.toModel(admin))));
    }

    @ApiOperation(value = "Put Admin", notes = "Devuelve el administrador que ha sido modificado.")
    @ApiResponse(code = 200, message = "OK", response = AdminDTO.class)
    @PutMapping("/update")
    public ResponseEntity<AdminDTO> updateAdmin(@RequestBody AdminDTO adminDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(repository.save(mapper.toModel(adminDTO))));
    }

    @ApiOperation(value = "Delete Admin", notes = "Devolverá una respuesta sin cuerpo.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content", response = AdminDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralError.class)
    })
    @DeleteMapping("/delete")
    public ResponseEntity deleteAdmin(@RequestParam(name = "id", required = true) UUID id) {
        repository.deleteById(id);
        Optional<Admin> admin = repository.findById(id);
        if (admin.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        }
    }
}
