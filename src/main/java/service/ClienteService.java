package service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ClienteRepository;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
}
