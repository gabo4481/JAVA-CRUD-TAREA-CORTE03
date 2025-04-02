package modelos;

import java.io.Serializable;

public abstract class Producto implements Serializable {
    private Integer ID;
    private String nombre;
    private static final long serialVersionUID = 1L;

    public Producto(Integer ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
