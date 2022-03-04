package application.configuration.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors
                                .basePackage("application")
                )
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Api Polideportivo")
                .description("Api de un polideportivo realizada en conjunto como práctica final de las asignaturas Acceso a Datos y Programación de Servicios ")
                .version("1.0")
                .contact(new Contact("Eneko Rebollo Hernández", "https://github.com/enekor", "enekorebollo@gmail.com"))
                .contact(new Contact("Saul", "https://github.com/saulmella12", "saulmella12@gmail.com"))
                .contact(new Contact("Dylan", "https://github.com/DyLaNHurtado", "lopeznovillo2000@gmail.com"))
                .contact(new Contact("Daniel Rodriguez Munoz", "https://github.com/Idliketobealoli", "daniel.ro.mu02@gmail.com"))
                .contact(new Contact("Emilio López Novillo", "https://github.com/emilio2403", "lopeznovillo2000@gmail.com"))
                .build();
    }
}
