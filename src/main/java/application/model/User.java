package application.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@NoArgsConstructor
public abstract class User {

    @ApiModelProperty(value = "Id usuario", dataType = "UUID", position = 1)
    private UUID id;
    @ApiModelProperty(value = "Nombre", dataType = "String", position = 2)
    private String nombre;
    @ApiModelProperty(value = "Correo", dataType = "String", position = 3)
    private String correo;
    @ApiModelProperty(value = "Contraseña", dataType = "String", position = 4)
    private String password;
    @ApiModelProperty(value = "Foto", dataType = "String", position = 5)
    private String foto;
    @ApiModelProperty(value = "Login", dataType = "Login", position = 6)
    private Login login;

    public User(String nombre, String correo, String password, String foto) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.foto = foto;
        id = UUID.randomUUID();
    }

    //TEST
    public User(UUID id, String nombre, String correo, String password, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.foto = foto;
    }

    @Id
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String corre) {
        this.correo = corre;
    }

    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Embedded
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
