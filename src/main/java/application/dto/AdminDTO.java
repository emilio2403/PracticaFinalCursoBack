package application.dto;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class AdminDTO {

    private UUID id;
    private String nombre;
    private String email;
    private String password;
    private String foto;

    @NotBlank(message = "Id no puede estar vacío")
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
