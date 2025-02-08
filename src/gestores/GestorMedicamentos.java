package gestores;

import modelos.Medicamento;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorMedicamentos {
    private ArrayList<Medicamento> medicamentos;
    private Scanner lectura;

    public GestorMedicamentos() {
        this.medicamentos = new ArrayList();
        this.lectura = new Scanner(System.in);
    }

    public void crearMedicamento(int ID) {
        try {
            System.out.println("Ingresa Nombre del modelos.Medicamento: ");
            String nombre = lectura.nextLine();

            System.out.println("Ingresa Principio Activo: ");
            String principio = lectura.nextLine();

            System.out.println("Ingresa cantidad: ");
            int cantidad = lectura.nextInt();
            lectura.nextLine();

            System.out.println("Ingresa laboratorio: ");
            String laboratorio = lectura.nextLine();

            Medicamento medicamento = new Medicamento(ID, nombre, principio, cantidad, laboratorio);
            medicamentos.add(medicamento);
            System.out.println("medicamento creado correctamente.");
        } catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }

    public void mostrarMedicamentos() {
        if (medicamentos.isEmpty()) {
            System.out.println("No hay medicamentos registrados.");
        } else {
            System.out.println("Lista de medicamentos: ");
            medicamentos.forEach(Medicamento::mostrarInformacion);
        }
    }

    public void editarMedicamento() {
        System.out.println("Ingresa el ID del medicamento a editar: ");
        int eleccionID = lectura.nextInt();
        lectura.nextLine();

        for(Medicamento medicamento : medicamentos){
            if(medicamento.getID().equals(eleccionID)){
                System.out.println("Ingresa nuevo Nombre del modelos.Medicamento: ");
                String nombre = lectura.nextLine();
                medicamento.setNombre(nombre);

                System.out.println("Ingresa nuevo Principio Activo: ");
                String principio = lectura.nextLine();
                medicamento.setPrincipioActivo(principio);

                System.out.println("Ingresa nueva cantidad: ");
                int cantidad = lectura.nextInt();
                lectura.nextLine();
                medicamento.setCantidad(cantidad);

                System.out.println("Ingresa nueva laboratorio: ");
                String laboratorio = lectura.nextLine();
                medicamento.setLaboratorio(laboratorio);

                System.out.println("medicamento actualizado correctamente");
                return;
            }
        }
        System.out.println("No se encontró un medicamento con el ID ingresado.");
    }

    public void eliminarMedicamento() {
        System.out.print("Ingresa el ID del medicamento a eliminar: ");
        int eleccionIDBorrado = lectura.nextInt();
        lectura.nextLine();

        if (medicamentos.removeIf(m -> m.getID().equals(eleccionIDBorrado))) {
            System.out.println("modelos.Medicamento eliminado correctamente.");
        } else {
            System.out.println("No se encontró un medicamento con el ID ingresado.");
        }
    }


}
