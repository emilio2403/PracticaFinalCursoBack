package application;

import application.model.Alquiler;
import application.model.Cliente;
import application.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@SpringBootApplication
public class PracticaFinalCursoBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticaFinalCursoBackApplication.class, args);
    }

    @Bean
    public CommandLineRunner initUsers(ClienteRepository clienteRepository) {
        List<Alquiler> lista = new ArrayList<>();
        return args -> {
            clienteRepository.deleteAll();
            clienteRepository.save(
                    new Cliente("Pepe", "pepe@gmail.com", "contraseña", "fotaza", lista)
            );
            clienteRepository.save(
                    new Cliente("Miguel", "miguel@gmail.com", "contraseña", "fotaza", lista)
            );
            clienteRepository.save(
                    new Cliente("Ana", "ana@gmail.com", "contraseña", "fotaza", lista)
            );
            clienteRepository.save(
                    new Cliente("Vinicius", "vinicius@gmail.com", "contraseña", "fotaza", lista)
            );

        };
    }
}
