package application.repository;

import application.model.Alquiler;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface AlquilerRepository extends MongoRepository<Alquiler, UUID> {
    Optional<Alquiler> getAlquilerByCliente_Id(UUID id); // si falla podemos usar: List<Alquiler> getAlquilerByCliente(Cliente cliente);
}
