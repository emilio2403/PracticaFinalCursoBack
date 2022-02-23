package application.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Admin extends User {

    public Admin(String nombre, String correo, String password, String foto) {
        super(nombre, correo, password, foto);
    }
}
