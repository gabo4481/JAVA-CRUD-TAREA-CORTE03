public class Medicamento {
    private Integer ID;
    private String nombre;
    private String principioActivo;
    private Integer cantidad;
    private String laboratorio;

    public Medicamento(Integer ID, String nombre, String principio_activo, Integer cantidad, String laboratorio) {
        this.ID = ID;
        this.nombre = nombre;
        this.principioActivo = principio_activo;
        this.cantidad = cantidad;
        this.laboratorio = laboratorio;
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

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    @Override
    public String toString() {
        return "Medicamento: " +
                "ID = " + ID +
                ", nombre = '" + nombre + '\'' +
                ", principioActivo = '" + principioActivo + '\'' +
                ", cantidad = " + cantidad +
                ", laboratorio = '" + laboratorio;
    }
}
