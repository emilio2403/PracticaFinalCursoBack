package application.model;

import application.configuration.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
public class Alquiler {

    private UUID id;
    private int year;
    private int month;
    private int day;
    private int inicio;
    private int fin;
    private double coste;
    @JsonView(Views.Alquiler.class)
    private Infraestructura infraestructura;
    @JsonView(Views.Alquiler.class)
    private Cliente cliente;

    public Alquiler(UUID id, double coste) {
        this.id = id;
        this.coste = coste;
    }

    @Id
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    @Basic
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Basic
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Basic
    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
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
