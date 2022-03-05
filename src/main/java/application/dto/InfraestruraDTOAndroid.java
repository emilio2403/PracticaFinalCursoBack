package application.dto;

import application.configuration.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

public class InfraestruraDTOAndroid {

    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Id infraestructura", dataType = "UUID", position = 1)
    private UUID id;
    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Tipo", dataType = "String", position = 2)
    private String tipo;
    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Foto", dataType = "String", position = 3)
    private String foto;
    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Descripción", dataType = "String", position = 4)
    private String descripcion;
}
