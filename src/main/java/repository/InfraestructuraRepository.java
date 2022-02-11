package repository;

import model.Infraestructura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfraestructuraRepository extends JpaRepository<Infraestructura, Long> {
    List<Infraestructura> findAllByTipo(String tipo);

}
