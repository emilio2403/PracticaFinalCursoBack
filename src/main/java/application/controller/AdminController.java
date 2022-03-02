package application.controller;

import application.dto.AdminDTO;
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

    @GetMapping(value = "/all")
    public ResponseEntity<List<AdminDTO>> getAllAdmin() {
        Optional<List<Admin>> admins = Optional.of(repository.findAll());
        if (admins.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTOList(admins.get()));
        } else {
            return ResponseEntity.ok().build();
        }
    }

    @PostMapping("/post")
    public ResponseEntity<AdminDTO> postAdmin(@RequestBody AdminDTO admin) {
        Optional<Admin> adminPost = Optional.of(repository.insert(mapper.toModel(admin)));
        if (adminPost.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(adminPost.get()));
        } else {
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Admin> deleteAdmin(@RequestParam(name = "id", required = true) UUID id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
