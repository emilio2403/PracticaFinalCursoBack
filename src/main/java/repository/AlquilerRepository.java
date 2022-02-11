package repository;

import model.Alquiler;
import model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
    List<Alquiler> getAlquilerByCliente_Id(long id); // si falla podemos usar: List<Alquiler> getAlquilerByCliente(Cliente cliente);
}
