package application.model;

import application.configuration.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.util.UUID;

@Embeddable
public class Login {
    @JsonView(Views.Admin.class)
    private LocalDateTime fecha;
    @JsonView({Views.Cliente.class, Views.Admin.class})
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
