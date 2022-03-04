package application.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
public class Infraestructura {

    @ApiModelProperty(value = "Id infraestructura", dataType = "UUID", position = 1)
    private UUID id;
    @ApiModelProperty(value = "Alquileres", dataType = "List<Alquiler>", position = 2)
    private List<Alquiler> alquileres;
    @ApiModelProperty(value = "Tipo", dataType = "String", position = 3)
    private String tipo;
    @ApiModelProperty(value = "Foto", dataType = "String", position = 4)
    private String foto;
    @ApiModelProperty(value = "Fecha de apertura", dataType = "LocalDateTime", position = 5)
    private LocalDateTime apertura;
    @ApiModelProperty(value = "Fecha de cierre", dataType = "LocalDateTime", position = 6)
    private LocalDateTime cierre;
    @ApiModelProperty(value = "Descripción", dataType = "String", position = 7)
    private String descripcion;

    public Infraestructura(List<Alquiler> alquileres, String tipo, String foto, LocalDateTime apertura, LocalDateTime cierre, String descripcion) {
        this.alquileres = alquileres;
        this.tipo = tipo;
        this.foto = foto;
        this.apertura = apertura;
        this.cierre = cierre;
        this.descripcion = descripcion;
        this.id = UUID.randomUUID();
    }

    @Id
    public UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    @OneToMany
    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }

    @Basic
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Basic
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Basic
    public LocalDateTime getApertura() {
        return apertura;
    }

    public void setApertura(LocalDateTime apertura) {
        this.apertura = apertura;
    }

    @Basic
    public LocalDateTime getCierre() {
        return cierre;
    }

    public void setCierre(LocalDateTime cierre) {
        this.cierre = cierre;
    }

    @Basic
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
