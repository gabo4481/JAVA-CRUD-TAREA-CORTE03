import gestores.GestorArchivos;
import gestores.GestorMedicamentos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        boolean condicion = true;
        GestorArchivos gestorArchivos = new GestorArchivos();
        GestorMedicamentos gestorMedicamentos = new GestorMedicamentos(gestorArchivos);

        int contadorID = gestorMedicamentos.obtenerIDMax() + 1;

        while (condicion){
            System.out.println("*******************************************************");
            System.out.println("1. Crear nuevo medicamento");
            System.out.println("2. Mostrar medicamentos");
            System.out.println("3. Editar un medicamento");
            System.out.println("4. Eliminar un medicamento");
            System.out.println("5. Medicamentos con stock bajo");
            System.out.println("6. Medicamentos con stock por laboratorio");
            System.out.println("7. Guardar Inventario");
            System.out.println("0. Salir");
            System.out.println("*******************************************************");

            System.out.println("Ingresa tu eleccion: ");
            int eleccion = lectura.nextInt();
            lectura.nextLine();

            switch (eleccion){
                case 1:
                    gestorMedicamentos.crearMedicamento(contadorID);
                    contadorID++;
                    break;
                case 2:
                    gestorMedicamentos.mostrarMedicamentos();
                    break;
                case 3:
                    gestorMedicamentos.editarMedicamento();
                    break;
                case 4:
                    gestorMedicamentos.eliminarMedicamento();
                    break;
                case 5:
                    System.out.println("Ingresa la cantidad maxima de medicamentos: ");
                    int umbral = lectura.nextInt();
                    lectura.nextLine();
                    gestorMedicamentos.stockBajo(umbral);
                    break;
                case 6:
                    gestorMedicamentos.stockPorLaboratorio();
                    break;
                case 7:
                    gestorArchivos.guardarDatos(gestorArchivos.getMedicamentos());
                    break;
                case 0:
                    condicion = false;
                    break;
                default: System.out.println("Ingresa una opcion valida");
            }
        }
    }
}
