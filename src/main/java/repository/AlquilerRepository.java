package repository;

import model.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {

    Optional<List<Alquiler>> getAlquilerByCliente_Id(long id); // si falla podemos usar: List<Alquiler> getAlquilerByCliente(Cliente cliente);
  
}
