package application.service;

import application.model.Infraestructura;
import application.repository.InfraestructuraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InfraestructuraService {

    private final InfraestructuraRepository repository;

    public Optional<List<Infraestructura>> getAllInfraestrucutura() {
        return Optional.of(repository.findAll());
    }

    public Optional<Infraestructura> getInfraestructuraById(UUID id) {
        return repository.findById(id);
    }

    public Optional<Infraestructura> insertInfraestructura(Infraestructura infraestructura) {
        return Optional.of(repository.save(infraestructura));
    }

    public Optional<Infraestructura> updateInfraestructura(Infraestructura infraestructura) {
        return insertInfraestructura(infraestructura);
    }

    public void deleteInfraestructura(UUID id) {
        repository.deleteById(id);
    }

    public Optional<List<Infraestructura>> getInfraestucturaByTipo(String tipo) {
        return repository.findAllByTipo(tipo);
    }
}
