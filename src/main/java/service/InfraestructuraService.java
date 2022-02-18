package service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.InfraestructuraRepository;

@Service
@RequiredArgsConstructor
public class InfraestructuraService {

    private final InfraestructuraRepository repository;
}
