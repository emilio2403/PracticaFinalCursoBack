package application;

import application.model.Cliente;
import application.model.Infraestructura;
import application.model.TipoPista;
import application.repository.ClienteRepository;
import application.repository.InfraestructuraRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@SpringBootApplication
public class PracticaFinalCursoBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticaFinalCursoBackApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatos(InfraestructuraRepository repository, ClienteRepository clienteRepository) {
        return (args) -> {
            repository.deleteAll();
            clienteRepository.deleteAll();
            
            repository.save(new Infraestructura(new ArrayList<>(), TipoPista.BALONCESTO.name(), "foto", LocalDateTime.now(), LocalDateTime.now(), "descripcion"));
            repository.save(new Infraestructura(new ArrayList<>(), TipoPista.TENIS.name(), "foto", LocalDateTime.now(), LocalDateTime.now(), "descripcion"));
            repository.save(new Infraestructura(new ArrayList<>(), TipoPista.VOLEY.name(), "foto", LocalDateTime.now(), LocalDateTime.now(), "descripcion"));
            repository.save(new Infraestructura(new ArrayList<>(), TipoPista.FUTBOL.name(), "foto", LocalDateTime.now(), LocalDateTime.now(), "descripcion"));
            repository.save(new Infraestructura(new ArrayList<>(), TipoPista.FUTBOLSALA.name(), "foto", LocalDateTime.now(), LocalDateTime.now(), "descripcion"));
            repository.save(new Infraestructura(new ArrayList<>(), TipoPista.PADEL.name(), "foto", LocalDateTime.now(), LocalDateTime.now(), "descripcion"));

            clienteRepository.save(new Cliente("Ansufati", "ansufati@gmail.com", "contraseña", "fotaza", new ArrayList<>()));
            clienteRepository.save(new Cliente("Obama", "obama@gmail.com", "contraseña", "fotaza", new ArrayList<>()));
            clienteRepository.save(new Cliente("Greta Thunberg", "salvaanimales@gmail.com", "contraseña", "fotaza", new ArrayList<>()));
            clienteRepository.save(new Cliente("Vinicius", "vinicius@gmail.com", "contraseña", "fotaza", new ArrayList<>()));
        };
    }
}