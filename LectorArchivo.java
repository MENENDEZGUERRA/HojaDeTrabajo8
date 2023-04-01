import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LectorArchivo {

    public static void main(String[] args) {
        try {
            File archivo = new File("procesos.txt");
            Scanner lector = new Scanner(archivo);
            VectorHeap<Proceso> procesos = new VectorHeap<>();
    
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] datos = linea.split(",");
                Proceso proceso = new Proceso(datos[0], datos[1], Integer.parseInt(datos[2]));
                System.out.println("Nuevo proceso creado: " + proceso);
                procesos.add(proceso);
            }
    
            lector.close();
    
            procesos.sort();
    
            System.out.println("Procesos ordenados:");
            while (!procesos.isEmpty()) {
                System.out.println(procesos.remove());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo.");
        } catch (NumberFormatException e) {
            System.out.println("Error al leer el valor 'nice'.");
        }
    }
    
}
