package application.model;

import application.configuration.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@NoArgsConstructor
public abstract class User {

    @JsonView({Views.Admin.class, Views.Cliente.class})
    private UUID id;
    @JsonView({Views.Admin.class, Views.Cliente.class, Views.Cliente.class})
    private String nombre;
    @JsonView({Views.Admin.class, Views.Cliente.class})
    private String correo;
    @JsonView({Views.Admin.class, Views.Cliente.class})
    private String password;
    @JsonView({Views.Admin.class, Views.Cliente.class})
    private String foto;
    @JsonView({Views.Admin.class, Views.Cliente.class})
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
