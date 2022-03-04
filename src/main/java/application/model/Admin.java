package application.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
@NoArgsConstructor
public class Admin extends User {

    public Admin(String nombre, String correo, String password, String foto) {
        super(nombre, correo, password, foto);
    }

    //TEST
    public Admin(UUID id, String nombre, String correo, String password, String foto) {
        super(id, nombre, correo, password, foto);
    }
}
