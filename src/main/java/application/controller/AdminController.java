package application.controller;

import application.dto.AdminDTO;
import application.error.GeneralError;
import application.mapper.AdminMapper;
import application.model.Admin;
import application.repository.AdminRepository;
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

    @GetMapping("/all")
    public ResponseEntity<List<AdminDTO>> getAllAdmin() {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTOList(repository.findAll()));
    }

    @GetMapping("/id")
    public ResponseEntity getAdminById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Admin> admin = repository.findById(id);
        if (admin.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(admin.get()));
        }
    }

    @PostMapping("/post")
    public ResponseEntity<AdminDTO> postAdmin(@RequestBody AdminDTO admin) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(repository.insert(mapper.toModel(admin))));
    }

    @PutMapping("/update")
    public ResponseEntity<AdminDTO> updateAdmin(@RequestBody AdminDTO adminDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(repository.save(mapper.toModel(adminDTO))));
    }

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
