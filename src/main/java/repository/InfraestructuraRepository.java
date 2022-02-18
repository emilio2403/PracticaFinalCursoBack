package repository;

import model.Infraestructura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InfraestructuraRepository extends JpaRepository<Infraestructura, Long> {
    Optional<List<Infraestructura>> findAllByTipo(String tipo);
}
