package application.repository;

import application.model.Infraestructura;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InfraestructuraRepository extends MongoRepository<Infraestructura, UUID> {
    Optional<List<Infraestructura>> findAllByTipo(String tipo);
}
