package model;

import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@NoArgsConstructor
@MappedSuperclass
public class User {

    private long id;
    private String nombre;
    private String corre;
    private String contraseña;
    private String foto;

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
    public String getCorre() {
        return corre;
    }

    public void setCorre(String corre) {
        this.corre = corre;
    }

    @Basic
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Basic
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
