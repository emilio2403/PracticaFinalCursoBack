package application.repository;

import application.model.Alquiler;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AlquilerRepository extends MongoRepository<Alquiler, Long> {
    Optional<List<Alquiler>> getAlquilerByCliente_Id(long id); // si falla podemos usar: List<Alquiler> getAlquilerByCliente(Cliente cliente);
}
