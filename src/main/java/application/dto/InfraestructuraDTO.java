package application.dto;

import application.configuration.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class InfraestructuraDTO {

    @JsonView({Views.Infraestructura.class, Views.Alquiler.class, Views.Cliente.class})
    private UUID id;
    @JsonView(Views.Infraestructura.class)
    private List<AlquilerDTO> alquileres;
    @JsonView({Views.Infraestructura.class, Views.Alquiler.class, Views.Cliente.class})
    private String tipo;
    @JsonView(Views.Infraestructura.class)
    private String foto;
    @JsonView(Views.Infraestructura.class)
    private LocalDateTime apertura;
    @JsonView(Views.Infraestructura.class)
    private LocalDateTime cierre;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<AlquilerDTO> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<AlquilerDTO> alquileres) {
        this.alquileres = alquileres;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public LocalDateTime getApertura() {
        return apertura;
    }

    public void setApertura(LocalDateTime apertura) {
        this.apertura = apertura;
    }

    public LocalDateTime getCierre() {
        return cierre;
    }

    public void setCierre(LocalDateTime cierre) {
        this.cierre = cierre;
    }
}
