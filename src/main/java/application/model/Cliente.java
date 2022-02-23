package application.model;

import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
public class Cliente extends User {

    private List<Alquiler> alquileres;

    public Cliente(String nombre, String correo, String password, String foto, List<Alquiler> alquileres) {
        super(nombre, correo, password, foto);
        this.alquileres = alquileres;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }
}
