package application.service;

import lombok.RequiredArgsConstructor;
import application.model.Alquiler;
import org.springframework.stereotype.Service;
import application.repository.AlquilerRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AlquilerService {

    private final AlquilerRepository repository;
    public Optional<List<Alquiler>> getAllAlquileres() {
        return Optional.of(repository.findAll());
    }
  
    public Optional<Alquiler> getAlquilerById(long id){
        return repository.findById(id);
    }
  
    public void deleteAlquilerById(long id){
        repository.deleteById(id);
    }
  
    public Optional<Alquiler> saveAlquiler(Alquiler alquiler){
        return Optional.of(repository.save(alquiler));
    }
  
    public Optional<List<Alquiler>> getAlquilerByClienteId(long id){
        return repository.getAlquilerByCliente_Id(id);
    }
}