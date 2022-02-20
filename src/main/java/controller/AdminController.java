package controller;

import lombok.RequiredArgsConstructor;
import model.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AdminService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService service;

    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmin(){
        Optional<List<Admin>> admins=service.getAllAdmin();
        if(admins.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(admins.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
