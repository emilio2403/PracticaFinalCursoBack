package application.repository;

import application.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends MongoRepository<Cliente, UUID> {
    Optional<Cliente> findByCorreo(String correo);
}
