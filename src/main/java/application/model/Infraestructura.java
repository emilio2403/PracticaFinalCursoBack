package application.model;

import application.configuration.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
public class Infraestructura {


    private UUID id;
    @JsonView(Views.Infraestructura.class)
    private List<Alquiler> alquileres;
    private String nombre;
    private String tipo;
    private String foto;
    private int apertura;
    private int cierre;
    private double coste;
    private String descripcion;

    public Infraestructura() {
        this.id = UUID.randomUUID();
    }

    public Infraestructura(UUID id, List<Alquiler> alquileres, String nombre, String tipo, String foto, int apertura, int cierre, double coste, String descripcion) {
        this.id = id;
        this.alquileres = alquileres;
        this.nombre = nombre;
        this.tipo = tipo;
        this.foto = foto;
        this.apertura = apertura;
        this.cierre = cierre;
        this.coste = coste;
        this.descripcion = descripcion;
    }

    // TEST
    public Infraestructura(UUID id, String tipo, String foto, int apertura, int cierre, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.foto = foto;
        this.apertura = apertura;
        this.cierre = cierre;
        this.descripcion = descripcion;
    }

    @Id
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    public int getApertura() {
        return apertura;
    }

    public void setApertura(int apertura) {
        this.apertura = apertura;
    }

    @Basic
    public int getCierre() {
        return cierre;
    }

    public void setCierre(int cierre) {
        this.cierre = cierre;
    }

    @Basic
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }
}
