package application.repository;

import application.model.Alquiler;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AlquilerRepository extends MongoRepository<Alquiler, UUID> {
    Optional<List<Alquiler>> getAlquilerByCliente_Id(long id); // si falla podemos usar: List<Alquiler> getAlquilerByCliente(Cliente cliente);
}
