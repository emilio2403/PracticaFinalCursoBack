package application.model;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.util.UUID;

@Embeddable
public class Login {

    private UUID id;
    private LocalDateTime fecha;
    private String token;


    public Login(LocalDateTime fecha, String token) {
        this.id = UUID.randomUUID();
        this.fecha = fecha;
        this.token = token;
    }

    public Login() {

    }

    @Basic
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
