package application.dto;

import application.configuration.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.time.LocalDateTime;
import java.util.UUID;

public class AlquilerDTO {
    @JsonView({Views.Infraestructura.class, Views.Alquiler.class, Views.Cliente.class})
    private UUID id;
    @JsonView({Views.Infraestructura.class, Views.Alquiler.class, Views.Cliente.class})
    private LocalDateTime inicio;
    @JsonView({Views.Infraestructura.class, Views.Alquiler.class, Views.Cliente.class})
    private LocalDateTime fin;
    @JsonView({Views.Infraestructura.class, Views.Alquiler.class, Views.Cliente.class})
    private double coste;
    @JsonView({Views.Alquiler.class, Views.Cliente.class})
    private InfraestructuraDTO infraestructura;
    @JsonView({Views.Infraestructura.class, Views.Alquiler.class})
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
