package application.dto;

import application.configuration.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

public class AlquilerDTO {

    @JsonView(Views.Alquiler.class)
    @ApiModelProperty(value = "Id alquiler", dataType = "UUID", position = 1)
    private UUID id;
    @JsonView(Views.Alquiler.class)
    @ApiModelProperty(value = "Hora de inicio", dataType = "Integer", position = 2)
    private int inicio;
    @JsonView(Views.Alquiler.class)
    @ApiModelProperty(value = "Hora de fin", dataType = "Integer", position = 3)
    private int fin;
    @JsonView(Views.Alquiler.class)
    @ApiModelProperty(value = "Coste", dataType = "Double", position = 4)
    private double coste;
    @JsonView(Views.Alquiler.class)
    @ApiModelProperty(value = "Infraestructura", dataType = "InfraestructuraDTO", position = 5)
    private InfraestructuraDTO infraestructura;
    @JsonView(Views.Alquiler.class)
    @ApiModelProperty(value = "Cliente", dataType = "ClienteDTO", position = 6)
    private ClienteDTO cliente;
    @JsonView(Views.Alquiler.class)
    @ApiModelProperty(value = "Año", dataType = "Integer", position = 7)
    private int year;
    @JsonView(Views.Alquiler.class)
    @ApiModelProperty(value = "Mes", dataType = "Integer", position = 8)
    private int month;
    @JsonView(Views.Alquiler.class)
    @ApiModelProperty(value = "Día", dataType = "Integer", position = 9)
    private int day;

    public AlquilerDTO() {
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

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
