package application.service;

import lombok.RequiredArgsConstructor;
import application.model.Infraestructura;
import org.springframework.stereotype.Service;

import application.repository.InfraestructuraRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InfraestructuraService {

    private final InfraestructuraRepository repository;
    public Optional<List<Infraestructura>> getAllInfraestrucutura(){
        return Optional.of(repository.findAll());
    }

    public Optional<Infraestructura> getInfraestructuraById(long id){
        return repository.findById(id);
    }

    public Optional<Infraestructura> insertInfraestructura(Infraestructura infraestructura){
        return Optional.of(repository.save(infraestructura));
    }

    public Optional<Infraestructura> updateInfraestructura(Infraestructura infraestructura){
        return insertInfraestructura(infraestructura);
    }

    public void deleteInfraestructura(long id){
        repository.deleteById(id);
    }

    public Optional<List<Infraestructura>> getInfraestucturaByTipo(String tipo){
        return  repository.findAllByTipo(tipo);
    }
}
