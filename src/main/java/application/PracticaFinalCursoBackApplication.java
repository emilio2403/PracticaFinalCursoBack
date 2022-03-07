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

import java.util.ArrayList;
import java.util.UUID;


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

            infraestructuraRepository.insert(new Infraestructura(UUID.fromString("19ff87dd-d97c-4e1a-8e23-bd628ad3ee54"), new ArrayList<>(), "Baloncesto1", TipoPista.BALONCESTO.name(), "foto", 9, 22, 10.0, "descripcion"));
            infraestructuraRepository.save(new Infraestructura(UUID.fromString("e2b1a0cb-a092-4364-955d-da41e420939b"), new ArrayList<>(), "Tenis1", TipoPista.TENIS.name(), "foto", 9, 22, 20.0, "descripcion"));
            infraestructuraRepository.save(new Infraestructura(UUID.fromString("d9c6df45-bf35-4bca-9094-39576cb44df2"), new ArrayList<>(), "Voley1", TipoPista.VOLEY.name(), "foto", 9, 22, 15.0, "descripcion"));
            infraestructuraRepository.save(new Infraestructura(UUID.fromString("b7705b87-6d11-45c4-9b5e-26508d8647ae"), new ArrayList<>(), "Futbol1", TipoPista.FUTBOL.name(), "foto", 9, 22, 10.0, "descripcion"));
            infraestructuraRepository.save(new Infraestructura(UUID.fromString("cc192bc7-0274-4469-9e93-a1e34088f658"), new ArrayList<>(), "Rugby1", TipoPista.RUGBY.name(), "foto", 9, 22, 10.0, "descripcion"));
            infraestructuraRepository.save(new Infraestructura(UUID.fromString("2df96f92-ab83-4186-aa5a-3f21bd56f5a3"), new ArrayList<>(), "Padel1", TipoPista.PADEL.name(), "foto", 9, 22, 15.0, "descripcion"));

            clienteRepository.save(new Cliente(UUID.fromString("3de4ea13-03d6-414b-91bb-928de48edfea"), "Ansufati", "a", "a", "fotaza", new ArrayList<>()));
            clienteRepository.save(new Cliente(UUID.fromString("4b568b31-5e0f-4bdd-871c-808968ef5799"), "Obama", "obama@gmail.com", "contraseña", "fotaza", new ArrayList<>()));
            clienteRepository.save(new Cliente(UUID.fromString("1cfbea98-b342-4c87-9c8d-e0e2e64560ce"), "Greta Thunberg", "salvaanimales@gmail.com", "contraseña", "fotaza", new ArrayList<>()));
            clienteRepository.save(new Cliente(UUID.fromString("25bcf1f5-b8d7-47fa-8ade-5e8a2d3f86a6"), "Vinicius", "vinicius@gmail.com", "contraseña", "fotaza", new ArrayList<>()));


            adminRepository.insert(new Admin("Emilio", "emilio@gmail.com", "admin", "url"));
            adminRepository.insert(new Admin("Neko", "neko@gmail.com", "admin", "url"));
            adminRepository.insert(new Admin("Dylan", "dylan@gmail.com", "admin", "url"));
            adminRepository.insert(new Admin("Saul", "saul@gmail.com", "admin", "url"));
            adminRepository.insert(new Admin("Loli", "loli@gmail.com", "admin", "url"));
        };
    }
}