package application.repository;

import application.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface AdminRepository extends MongoRepository<Admin, UUID> {
}

