package application.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
public class Alquiler {

    @ApiModelProperty(value = "Id alquiler", dataType = "UUID", position = 1)
    private UUID id;
    @ApiModelProperty(value = "Fecha inicio", dataType = "LocalDateTime", position = 2)
    private LocalDateTime inicio;
    @ApiModelProperty(value = "Fecha fin", dataType = "LocalDateTime", position = 3)
    private LocalDateTime fin;
    @ApiModelProperty(value = "Coste", dataType = "Double", position = 4)
    private double coste;
    @ApiModelProperty(value = "Infraestructura", dataType = "Infraestructure", position = 5)
    private Infraestructura infraestructura;
    @ApiModelProperty(value = "Cliente", dataType = "Cliente", position = 6)
    private Cliente cliente;

    public Alquiler(UUID id, double coste) {
        this.id = id;
        this.coste = coste;
    }


    @Id
    public UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    @Basic
    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    @Basic
    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    @Basic
    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "alquileres")
    public Infraestructura getInfraestructura() {
        return infraestructura;
    }

    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "alquileres")
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
