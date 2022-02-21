package application.service;

import lombok.RequiredArgsConstructor;
import application.model.Cliente;
import org.springframework.stereotype.Service;
import application.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;

    public Optional<Cliente> findClientByEmail(String email) {
        return repository.findByCorreo(email);
    }

    public Optional<Cliente> findClientById(Long id) {
        return repository.findById(id);
    }

    public Optional<List<Cliente>> getAllClients() {
        return Optional.of(repository.findAll());
    }

    public void deleteClientById(Long id) {
        repository.deleteById(id);
    }

    public Optional<Cliente> postClient(Cliente cliente){
        return Optional.of(repository.save(cliente));
    }
}
