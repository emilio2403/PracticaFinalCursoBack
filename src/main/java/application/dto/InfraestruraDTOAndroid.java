package application.dto;

import application.configuration.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.UUID;

public class InfraestruraDTOAndroid {

    @JsonView(Views.Infraestructura.class)
    private UUID id;
    @JsonView(Views.Infraestructura.class)
    private String tipo;
    @JsonView(Views.Infraestructura.class)
    private String foto;
    @JsonView(Views.Infraestructura.class)
    private String descripcion;
}
