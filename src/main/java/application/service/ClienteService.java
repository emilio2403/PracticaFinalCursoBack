package application.service;

import application.model.Cliente;
import application.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;

    public Optional<Cliente> findClientByEmail(String email) {
        return repository.findByCorreo(email);
    }

    public Optional<Cliente> findClientById(UUID id) {
        return repository.findById(id);
    }

    public Optional<List<Cliente>> getAllClients() {
        return Optional.of(repository.findAll());
    }

    public void deleteClientById(UUID id) {
        repository.deleteById(id);
    }

    public Optional<Cliente> postClient(Cliente cliente) {
        return Optional.of(repository.save(cliente));
    }
}
