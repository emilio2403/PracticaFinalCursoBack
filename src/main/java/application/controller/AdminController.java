package application.controller;

import application.dto.AdminDTO;
import lombok.RequiredArgsConstructor;
import application.mapper.AdminMapper;
import application.model.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import application.service.AdminService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService service;
    private final AdminMapper mapper;

    @GetMapping("/all")
    public ResponseEntity<List<AdminDTO>> getAllAdmin(){
        Optional<List<Admin>> admins=service.getAllAdmin();
        if(admins.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTOList(admins.get()));
        }else{
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping("/prueba")
    public ResponseEntity<String> prueba(){
        return ResponseEntity.status(HttpStatus.OK).body("Prueba");
    }

    @PostMapping("/post")
    public ResponseEntity<AdminDTO> postAdmin(@RequestBody AdminDTO admin){
        Optional<Admin> adminPost=service.postAdmin(mapper.toModel(admin));
        if(adminPost.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(adminPost.get()));
        }else{
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Admin> deleteAdmin(@RequestParam(name="id",required=true) long id){
        try{
            service.deleteAdminById(id);
            return ResponseEntity.noContent().build();
        }catch(RuntimeException e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
