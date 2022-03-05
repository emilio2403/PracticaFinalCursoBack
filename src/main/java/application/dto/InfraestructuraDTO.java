package application.dto;

import application.configuration.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class InfraestructuraDTO {

    @JsonView({Views.Infraestructura.class, Views.Alquiler.class, Views.Cliente.class})
    @ApiModelProperty(value = "Id infraestructura", dataType = "UUID", position = 1)
    private UUID id;
    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Lista alquileres", position = 2)
    private List<AlquilerDTO> alquileres;
    @JsonView({Views.Infraestructura.class, Views.Alquiler.class, Views.Cliente.class})
    @ApiModelProperty(value = "Tipo", dataType = "String", position = 3)
    private String tipo;
    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Foto", dataType = "String", position = 4)
    private String foto;
    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Fecha de apertura", dataType = "LocalDateTime", position = 5)
    private LocalDateTime apertura;
    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Fecha de cierre", dataType = "LocalDateTime", position = 6)
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

    public InfraestructuraDTO() {
        this.id = UUID.randomUUID();
    }

    public InfraestructuraDTO(List<AlquilerDTO> alquileres, String tipo, String foto, LocalDateTime apertura, LocalDateTime cierre) {
        this.id = UUID.randomUUID();
        this.alquileres = alquileres;
        this.tipo = tipo;
        this.foto = foto;
        this.apertura = apertura;
        this.cierre = cierre;
    }

    // TEST
    public InfraestructuraDTO(UUID id, String tipo, String foto, LocalDateTime apertura, LocalDateTime cierre) {
        this.id = id;
        this.tipo = tipo;
        this.foto = foto;
        this.apertura = apertura;
        this.cierre = cierre;
    }
}
