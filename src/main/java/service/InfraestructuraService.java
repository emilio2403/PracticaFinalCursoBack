package service;

import lombok.RequiredArgsConstructor;
import model.Infraestructura;
import org.springframework.stereotype.Service;

import repository.ClienteRepository;
import repository.InfraestructuraRepository;

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
        return Optional.of(repository.getById(id));
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
