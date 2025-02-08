import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner lectura = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Medicamento> medicamentos = new ArrayList<>();
        int contadorID = 1;
        boolean condicion = true;

        while (condicion){
            System.out.println("*******************************************************");
            System.out.println("1. Crear Nuevo Medicamento");
            System.out.println("2. Mostrar Medicamentos");
            System.out.println("3. Editar un Medicamento");
            System.out.println("4. Eliminar un Medicamento");
            System.out.println("0. Salir");
            System.out.println("*******************************************************");

            System.out.println("Ingresa tu eleccion: ");
            int eleccion = lectura.nextInt();
            lectura.nextLine();

            switch (eleccion){
                case 1:
                    crearMedicamento(contadorID, medicamentos);
                    contadorID++;
                    break;
                case 2:
                    mostrarMedicamentos(medicamentos);
                    break;
                case 3:
                    editarMedicamento(medicamentos);
                    break;
                case 4:
                    eliminarMedicamento(medicamentos);
                    break;
                case 0:
                    condicion = false;
                    break;
                default: System.out.println("Opcion no valida");
            }
        }
    }

    private static void eliminarMedicamento(ArrayList<Medicamento> medicamentos) {
        System.out.print("Ingresa el ID del medicamento a eliminar: ");
        int eleccionIDBorrado = lectura.nextInt();
        lectura.nextLine();

        if (medicamentos.removeIf(m -> m.getID().equals(eleccionIDBorrado))) {
            System.out.println("Medicamento eliminado correctamente.");
        } else {
            System.out.println("No se encontró un medicamento con el ID ingresado.");
        }
    }

    private static void editarMedicamento(ArrayList<Medicamento> medicamentos) {
        System.out.println("Ingresa el ID del medicamento a editar: ");
        int eleccionID = lectura.nextInt();
        lectura.nextLine();

        for(Medicamento medicamento : medicamentos){
            if(medicamento.getID().equals(eleccionID)){
                System.out.println("Ingresa nuevo Nombre del Medicamento: ");
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
            }else {
                System.out.println("Ingresa un ID valido.");
            }
        }
    }

    private static void mostrarMedicamentos(ArrayList<Medicamento> medicamentos) {
        System.out.println("\n Listado de Medicamentos: ");
        medicamentos.forEach(System.out::println);
    }

    private static void crearMedicamento(int ID,ArrayList<Medicamento> medicamentos) {
        try {
            System.out.println("Ingresa Nombre del Medicamento: ");
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
}
