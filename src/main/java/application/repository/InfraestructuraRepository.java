package application.repository;

import application.model.Infraestructura;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface InfraestructuraRepository extends MongoRepository<Infraestructura, Long> {
    Optional<List<Infraestructura>> findAllByTipo(String tipo);
}
