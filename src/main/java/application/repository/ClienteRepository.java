package application.repository;

import application.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClienteRepository extends MongoRepository<Cliente,Long> {
    Optional<Cliente> findByCorreo(String correo);
}
