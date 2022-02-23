package application.model;

import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@NoArgsConstructor
public class User {

    private long id;
    private String nombre;
    private String correo;
    private String password;
    private String foto;
    private Login login;

    public User(String nombre, String correo, String password, String foto) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.foto = foto;
    }

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
