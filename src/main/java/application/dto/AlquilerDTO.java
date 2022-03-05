package application.dto;

import application.configuration.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public class AlquilerDTO {
    @JsonView({Views.Infraestructura.class, Views.Alquiler.class, Views.Cliente.class})
    @ApiModelProperty(value = "Id alquiler", dataType = "UUID", position = 1)
    private UUID id;
    @JsonView({Views.Infraestructura.class, Views.Alquiler.class, Views.Cliente.class})
    @ApiModelProperty(value = "Fecha inicio", dataType = "LocalDateTime", position = 2)
    private LocalDateTime inicio;
    @JsonView({Views.Infraestructura.class, Views.Alquiler.class, Views.Cliente.class})
    @ApiModelProperty(value = "Fecha fin", dataType = "LocalDateTime", position = 3)
    private LocalDateTime fin;
    @JsonView({Views.Infraestructura.class, Views.Alquiler.class, Views.Cliente.class})
    @ApiModelProperty(value = "Coste", dataType = "Double", position = 4)
    private double coste;
    @JsonView({Views.Alquiler.class, Views.Cliente.class})
    @ApiModelProperty(value = "Infraestructura", dataType = "InfraestructuraDTO", position = 5)
    private InfraestructuraDTO infraestructura;
    @JsonView({Views.Infraestructura.class, Views.Alquiler.class})
    @ApiModelProperty(value = "Cliente", dataType = "ClienteDTO", position = 6)
    private ClienteDTO cliente;

    public AlquilerDTO() {
        this.id = UUID.randomUUID();
    }

    public AlquilerDTO(double coste) {
        this.id = UUID.randomUUID();
        this.coste = coste;
    }

    //TEST
    public AlquilerDTO(UUID id, double coste) {
        this.id = id;
        this.coste = coste;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public InfraestructuraDTO getInfraestructura() {
        return infraestructura;
    }

    public void setInfraestructura(InfraestructuraDTO infraestructura) {
        this.infraestructura = infraestructura;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
}
