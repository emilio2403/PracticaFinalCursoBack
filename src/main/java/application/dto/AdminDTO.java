package application.dto;

import application.configuration.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

public class AdminDTO {

    @JsonView(Views.Admin.class)
    @ApiModelProperty(value = "Id admin", dataType = "UUID", position = 1)
    private UUID id;
    @JsonView(Views.Admin.class)
    @ApiModelProperty(value = "Nombre", dataType = "String", position = 2)
    private String nombre;
    @JsonView(Views.Admin.class)
    @ApiModelProperty(value = "Email", dataType = "String", position = 3)
    private String email;
    @JsonView(Views.Admin.class)
    @ApiModelProperty(value = "Contraseña", dataType = "String", position = 4)
    private String password;
    @JsonView(Views.Admin.class)
    @ApiModelProperty(value = "Foto", dataType = "String", position = 5)
    private String foto;

    public AdminDTO() {
        this.id = UUID.randomUUID();
    }

    public AdminDTO(String nombre, String email, String password, String foto) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.foto = foto;
    }

    //TEST
    public AdminDTO(UUID id, String nombre, String email, String password, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.foto = foto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
