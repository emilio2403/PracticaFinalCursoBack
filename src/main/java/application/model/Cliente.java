package application.model;

import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
public class Cliente extends User {

    private List<Alquiler> alquileres;

    public Cliente(String nombre, String correo, String password, String foto, List<Alquiler> alquileres) {
        super(nombre, correo, password, foto);
        this.alquileres = alquileres;
    }

    public Cliente(UUID id, String nombre, String correo, String password, String foto) {
        super(id, nombre, correo, password, foto);
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }
}
