package gestores;

import modelos.Medicamento;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class GestorMedicamentos {
    private ArrayList<Medicamento> medicamentos;
    private Scanner lectura;
    private GestorArchivos gestorArchivos = new GestorArchivos();


    public GestorMedicamentos(GestorArchivos gestorArchivos) {
        this.gestorArchivos = gestorArchivos;
        this.medicamentos = gestorArchivos.getMedicamentos();
        this.lectura = new Scanner(System.in);
    }

    public int obtenerIDMax(){
        if (medicamentos.isEmpty()){
            return 0;
        }

        return medicamentos.stream().mapToInt(Medicamento::getID).max().orElse(0);
    }

    public void crearMedicamento(int ID) {
        try {
            System.out.println("Ingresa Nombre del medicamento: ");
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
            if (medicamento.getID() == eleccionID) {
                System.out.println("Ingresa nuevo Nombre del medicamento: ");
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

            if (medicamentos.removeIf(m -> m.getID() == eleccionIDBorrado)) {
            System.out.println("Medicamento eliminado correctamente.");
        } else {
            System.out.println("No se encontró un medicamento con el ID ingresado.");
        }
    }

    public void stockBajo(int umbral) {
        List<String> reporte = medicamentos.stream()
                .filter(m -> m.getCantidad() < umbral)
                .map(Medicamento::mostrarInformacionReporte01)
                .toList();

        SolicitudGuardado(reporte);
    }


    public void stockPorLaboratorio() {
        List<String> reporte = medicamentos.stream()
                .collect(Collectors.groupingBy(
                        Medicamento::getLaboratorio,
                        Collectors.summarizingInt(Medicamento::getCantidad)
                ))
                .entrySet().stream()
                .map(entry -> entry.getKey() + " - cantidad: " + entry.getValue().getSum())
                .collect(Collectors.toList());

        SolicitudGuardado(reporte);
    }

    private void SolicitudGuardado(List<String> reporte) {
        for (String linea : reporte){
            System.out.println(linea);
        }

        System.out.println("¿Deseas guardar el reporte? 1.SI 2.NO");
        int respuesta;
        while (true) {
            if (lectura.hasNextInt()) {
                respuesta = lectura.nextInt();
                lectura.nextLine();
                if (respuesta == 1 || respuesta == 2) break;
            } else {
                lectura.next();
            }
            System.out.println("Opción inválida. Ingresa 1 para SI o 2 para NO.");
        }

        if (respuesta == 1) {
            String nombre;
            do {
                System.out.println("Ingresa el nombre del archivo (sin .txt):");
                nombre = lectura.nextLine().trim();
            } while (nombre.isEmpty());

            gestorArchivos.guardarReporte(nombre,reporte);
        }
    }
}
