package application.dto;

import application.configuration.views.Views;
import application.model.Login;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.UUID;

public class ClienteDTO {

    @JsonView(Views.Cliente.class)
    @ApiModelProperty(value = "Id cliente", dataType = "UUID", position = 1)
    private UUID id;
    @JsonView(Views.Cliente.class)
    @ApiModelProperty(value = "Nombre", dataType = "String", position = 2)
    private String nombre;
    @JsonView(Views.Cliente.class)
    @ApiModelProperty(value = "Correo", dataType = "String", position = 3)
    private String correo;
    @JsonView(Views.Cliente.class)
    @ApiModelProperty(value = "Contraseña", dataType = "String", position = 4)
    private String password;
    @JsonView(Views.Cliente.class)
    @ApiModelProperty(value = "Foto", dataType = "String", position = 5)
    private String foto;
    @JsonView(Views.Cliente.class)
    @ApiModelProperty(value = "Lista de alquileres", dataType = "List<AlquilerDTO>", position = 6)
    private List<AlquilerDTO> alquileres;
    @JsonView(Views.Cliente.class)
    @ApiModelProperty(value = "Login", dataType = "List<AlquilerDTO>", position = 6)
    private Login login;

    public ClienteDTO() {
        
    }

    public ClienteDTO(String nombre, String correo, String password, String foto, List<AlquilerDTO> alquileres) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.foto = foto;
        this.alquileres = alquileres;
        this.id = UUID.randomUUID();
    }

    // TEST
    public ClienteDTO(UUID id, String nombre, String correo, String password, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
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
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
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

    public List<AlquilerDTO> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<AlquilerDTO> alquileres) {
        this.alquileres = alquileres;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
