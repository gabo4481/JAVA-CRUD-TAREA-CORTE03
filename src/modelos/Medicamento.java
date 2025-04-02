package modelos;

import interfaces.Informacion;

import java.io.Serializable;

public class Medicamento extends Producto implements Informacion,Serializable {
    private String principioActivo;
    private Integer cantidad;
    private String laboratorio;

    public Medicamento(Integer ID, String nombre, String principioActivo, Integer cantidad, String laboratorio) {
        super(ID, nombre);
        this.cantidad = cantidad;
        this.principioActivo = principioActivo;
        this.laboratorio = laboratorio;
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
    public void mostrarInformacion() {
        System.out.println("Medicamento ID: " + getID() + ", Nombre: " + getNombre() + ", Principio Activo: " + principioActivo +
                ", Cantidad: " + cantidad + ", Laboratorio: " + laboratorio);
    }

    @Override
    public String mostrarInformacionReporte01(){
        return getID()+". "+getNombre()+" - cantidad: "+getCantidad();
    }
}
