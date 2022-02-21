package application.dto;

import javax.validation.constraints.NotBlank;

public class AdminDTO {

    private long id;
    private String nombre;
    private String corre;
    private String password;
    private String foto;

    @NotBlank(message="Id no puede estar vacío")
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorre() {
        return this.corre;
    }

    public void setCorre(String corre) {
        this.corre = corre;
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
