package service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.AlquilerRepository;

@Service
@RequiredArgsConstructor
public class AlquilerService {

    private final AlquilerRepository repository;
}
