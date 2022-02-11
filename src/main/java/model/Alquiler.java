package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Alquiler {

    private long id;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private double coste;
    private Infraestructura infraestructura;
    private Cliente cliente;

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
