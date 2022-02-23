package application;

import application.model.Admin;
import application.model.Cliente;
import application.model.Infraestructura;
import application.model.TipoPista;
import application.repository.AdminRepository;
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
public class PracticaFinalCursoBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticaFinalCursoBackApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatos(InfraestructuraRepository infraestructuraRepository, ClienteRepository clienteRepository,
                                       AdminRepository adminRepository) {
        return (args) -> {
            infraestructuraRepository.deleteAll();
            clienteRepository.deleteAll();
            adminRepository.deleteAll();

            infraestructuraRepository.save(new Infraestructura(new ArrayList<>(), TipoPista.BALONCESTO.name(), "foto", LocalDateTime.now(), LocalDateTime.now(), "descripcion"));
            infraestructuraRepository.save(new Infraestructura(new ArrayList<>(), TipoPista.TENIS.name(), "foto", LocalDateTime.now(), LocalDateTime.now(), "descripcion"));
            infraestructuraRepository.save(new Infraestructura(new ArrayList<>(), TipoPista.VOLEY.name(), "foto", LocalDateTime.now(), LocalDateTime.now(), "descripcion"));
            infraestructuraRepository.save(new Infraestructura(new ArrayList<>(), TipoPista.FUTBOL.name(), "foto", LocalDateTime.now(), LocalDateTime.now(), "descripcion"));
            infraestructuraRepository.save(new Infraestructura(new ArrayList<>(), TipoPista.FUTBOLSALA.name(), "foto", LocalDateTime.now(), LocalDateTime.now(), "descripcion"));
            infraestructuraRepository.save(new Infraestructura(new ArrayList<>(), TipoPista.PADEL.name(), "foto", LocalDateTime.now(), LocalDateTime.now(), "descripcion"));

            clienteRepository.save(new Cliente("Ansufati", "ansufati@gmail.com", "contraseña", "fotaza", new ArrayList<>()));
            clienteRepository.save(new Cliente("Obama", "obama@gmail.com", "contraseña", "fotaza", new ArrayList<>()));
            clienteRepository.save(new Cliente("Greta Thunberg", "salvaanimales@gmail.com", "contraseña", "fotaza", new ArrayList<>()));
            clienteRepository.save(new Cliente("Vinicius", "vinicius@gmail.com", "contraseña", "fotaza", new ArrayList<>()));


            adminRepository.insert(new Admin("Emilio", "emilio@gmail.com", "admin", "url"));
            adminRepository.insert(new Admin("Neko", "neko@gmail.com", "admin", "url"));
            adminRepository.insert(new Admin("Dylan", "dylan@gmail.com", "admin", "url"));
            adminRepository.insert(new Admin("Saul", "saul@gmail.com", "admin", "url"));
            adminRepository.insert(new Admin("Loli", "loli@gmail.com", "admin", "url"));
        };
    }
}