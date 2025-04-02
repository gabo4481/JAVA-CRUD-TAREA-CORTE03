package gestores;

import modelos.Medicamento;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class GestorArchivos {
    private static final String ARCHIVO_DATOS = "src/inventario/datos.bin";
    private ArrayList<Medicamento> medicamentos = new ArrayList<>();

    public GestorArchivos() {
        this.medicamentos = cargarDatos();
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void guardarReporte(String nombre, List<String> reporte){
        File archivo = new File("src/reportes/"+nombre+".txt");
        try(FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("Nombre del reporte: "+nombre+"\n");
            for(String linea : reporte){
                bw.write(linea);
                bw.newLine();
            }
        }catch (IOException e){
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }
    }

    private ArrayList<Medicamento> cargarDatos(){
        File archivo = new File(ARCHIVO_DATOS);
        if (archivo.exists()){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))){
                medicamentos = (ArrayList<Medicamento>) ois.readObject();
                System.out.println("Datos cargados con exito.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar los datos: "+e.getMessage());
            }
        }else {
            System.out.println("No hay datos previos, se inicia la lista vacia.");
            medicamentos = new ArrayList<>();
        }
        return medicamentos ;
    }

    public void guardarDatos(ArrayList<Medicamento> medicamentos){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_DATOS))){
            oos.writeObject(this.medicamentos);
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: "+e.getMessage());
        }
    }

}