package service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.AdminRepository;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository repository;


}
