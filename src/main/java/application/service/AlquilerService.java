package application.service;

import application.model.Alquiler;
import application.repository.AlquilerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AlquilerService {

    private final AlquilerRepository repository;

    public Optional<List<Alquiler>> getAllAlquileres() {
        return Optional.of(repository.findAll());
    }

    public Optional<Alquiler> getAlquilerById(UUID id) {
        return repository.findById(id);
    }

    public void deleteAlquilerById(UUID id) {
        repository.deleteById(id);
    }

    public Optional<Alquiler> saveAlquiler(Alquiler alquiler) {
        return Optional.of(repository.save(alquiler));
    }

    public Optional<List<Alquiler>> getAlquilerByClienteId(UUID id) {
        return repository.getAlquilerByCliente_Id(id);
    }
}
