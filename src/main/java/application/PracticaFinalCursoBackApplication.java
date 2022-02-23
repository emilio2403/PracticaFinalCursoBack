package application;

import application.model.Admin;
import application.repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PracticaFinalCursoBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticaFinalCursoBackApplication.class, args);
    }

    @Bean
    public CommandLineRunner initAdmins(AdminRepository repository) {
        return (args) -> {
            repository.deleteAll();
            repository.insert(new Admin("Emilio", "emilio@gmail.com", "admin", "url"));
            repository.insert(new Admin("Neko", "neko@gmail.com", "admin", "url"));
            repository.insert(new Admin("Dylan", "dylan@gmail.com", "admin", "url"));
            repository.insert(new Admin("Saul", "saul@gmail.com", "admin", "url"));
            repository.insert(new Admin("Loli", "loli@gmail.com", "admin", "url"));
        };
    }
}
