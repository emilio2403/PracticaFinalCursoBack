package repository;

import model.Infraestructura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

//public interface InfraestructuraRepository extends MongoRepository<Infraestructura,Long> {
public interface InfraestructuraRepository extends JpaRepository<Infraestructura, Long> {
    Optional<List<Infraestructura>> findAllByTipo(String tipo);
}
