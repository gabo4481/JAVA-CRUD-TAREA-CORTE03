import gestores.GestorMedicamentos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int contadorID = 1;
        boolean condicion = true;
        GestorMedicamentos gestor = new GestorMedicamentos();

        while (condicion){
            System.out.println("*******************************************************");
            System.out.println("1. Crear nuevo medicamento");
            System.out.println("2. Mostrar medicamentos");
            System.out.println("3. Editar un medicamento");
            System.out.println("4. Eliminar un medicamento");
            System.out.println("0. Salir");
            System.out.println("*******************************************************");

            System.out.println("Ingresa tu eleccion: ");
            int eleccion = lectura.nextInt();
            lectura.nextLine();

            switch (eleccion){
                case 1:
                    gestor.crearMedicamento(contadorID);
                    contadorID++;
                    break;
                case 2:
                    gestor.mostrarMedicamentos();
                    break;
                case 3:
                    gestor.editarMedicamento();
                    break;
                case 4:
                    gestor.eliminarMedicamento();
                    break;
                case 0:
                    condicion = false;
                    break;
                default: System.out.println("Ingresa una opcion valida");
            }
        }
    }








}
