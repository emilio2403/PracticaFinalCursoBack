package application.service;

import application.model.Admin;
import application.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository repository;

    public Optional<List<Admin>> getAllAdmin() {
        return Optional.of(repository.findAll());
    }

    public Optional<Admin> getAdminById(UUID id) {
        return repository.findById(id);
    }

    public void deleteAdminById(UUID id) {
        repository.deleteById(id);
    }

    public Optional<Admin> postAdmin(Admin admin) {
        return Optional.of(repository.save(admin));
    }
}
