package application.dto;

import application.configuration.views.Views;
import application.model.Alquiler;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.UUID;

public class InfraestructuraDTO {

    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Id infraestructura", dataType = "UUID", position = 1)
    private UUID id;
    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Lista alquileres", position = 2)
    private List<Alquiler> alquileres;
    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Nombre", dataType = "String", position = 3)
    private String nombre;
    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Tipo", dataType = "String", position = 4)
    private String tipo;
    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Foto", dataType = "String", position = 5)
    private String foto;
    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Hora de apertura", dataType = "Integer", position = 6)
    private int apertura;
    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Hora de cierre", dataType = "Integer", position = 7)
    private int cierre;
    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Coste por hora", dataType = "Double", position = 8)
    private double coste;
    @JsonView(Views.Infraestructura.class)
    @ApiModelProperty(value = "Descripcion", dataType = "String", position = 9)
    private String descripcion;

    public InfraestructuraDTO() {
        id = UUID.randomUUID();
    }

    public InfraestructuraDTO(UUID id, List<Alquiler> alquileres, String nombre, String tipo, String foto, int apertura, int cierre, double coste, String descripcion) {
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
    public InfraestructuraDTO(UUID id, String tipo, String foto, int apertura, int cierre) {
        this.id = id;
        this.tipo = tipo;
        this.foto = foto;
        this.apertura = apertura;
        this.cierre = cierre;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquiler> alquileres) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getApertura() {
        return apertura;
    }

    public void setApertura(int apertura) {
        this.apertura = apertura;
    }

    public int getCierre() {
        return cierre;
    }

    public void setCierre(int cierre) {
        this.cierre = cierre;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "InfraestructuraDTO{" +
                "id=" + id +
                ", alquileres=" + alquileres +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", foto='" + foto + '\'' +
                ", apertura=" + apertura +
                ", cierre=" + cierre +
                ", coste=" + coste +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
