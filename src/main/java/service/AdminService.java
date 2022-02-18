package service;

import lombok.RequiredArgsConstructor;
import model.Admin;
import org.springframework.stereotype.Service;
import repository.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository repository;

    public Optional<List<Admin>> getAllAdmin(){
        return Optional.of(repository.findAll());
    }

    public Optional<Admin> getAdminById(Long id){
        return repository.findById(id);
    }

    public void deleteAdminById(Long id){
        repository.deleteById(id);
    }

    public Optional<Admin> postAdmin(Admin admin){
        return Optional.of(repository.save(admin));
    }
}
