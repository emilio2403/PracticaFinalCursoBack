package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="login")
public class Login {
    private long id;
    private LocalDateTime fecha;
    private String token;


    public Login(long id, LocalDateTime fecha, String token) {
        this.id = id;
        this.fecha = fecha;
        this.token = token;
    }

    public Login() {

    }
    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Basic
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    @Basic
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", token='" + token + '\'' +
                '}';
    }
}
