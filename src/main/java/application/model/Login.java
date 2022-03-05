package application.model;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.util.UUID;

@Embeddable
public class Login {

    private LocalDateTime fecha;
    private UUID token;

    public Login() {
    }

    public Login(LocalDateTime fecha, UUID token) {
        this.fecha = fecha;
        this.token = token;
    }

    @Basic
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Basic
    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
