import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LectorArchivo {
    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        int op = 0;
        do{ // Menu simple para escoger implementación
            System.out.println("Escoga su implementación de PriorityQueue:");
            System.out.println("1. VectorHeap");
            System.out.println("2. JavaCollectionsFramework");
            Scanner scan = new Scanner(System.in);
             try{
                 op = scan.nextInt();
             } catch(Exception e){

             }
        } while(op<1 || op>2);

        if(op==1){
            System.out.println("Implementación VectorHeap");
            LectorVH();
        } else{
            System.out.println("Implementación JavaCollectionsFramework");
            LectorJCF();
        }

    }


    /**
     * Lee el archivo guardando los datos en un VectorHeap
     *
     * Luego imprime los datos de cada elemento que elimina del Heap
     */

    public static void LectorVH(){
        try {
            File archivo = new File("procesos.txt");
            Scanner lector = new Scanner(archivo);
            VectorHeap<Proceso> procesos = new VectorHeap<>();  // VectorHeap

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] datos = linea.split(",");
                Proceso proceso = new Proceso(datos[0], datos[1], Integer.parseInt(datos[2]));
                // Convierte texto en clases Proceso
                System.out.println("*** Proceso identificado: " + proceso.getNombreProceso());
                procesos.add(proceso); // Guarda en VectorHeap
            }
            lector.close();
            System.out.println("");
            while (!procesos.isEmpty()) {
                Proceso tem = procesos.remove(); // Elimina e Imprime datos
                System.out.println(tem.getNombreProceso()+","+tem.getNombreUsuario()+","
                        +tem.getValorNice()+", PR = "+(tem.getValorNice()+120));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo.");
        } catch (NumberFormatException e) {
            System.out.println("Error al leer el valor 'nice'.");
        }
    }

    /**
     * Lee el archivo guardando los datos en un PriorityQueue propio de JavaCollectionsFramwork
     *
     * Luego imprime los datos de cada elemento que elimina del Heap
     */
    public static void LectorJCF(){
        try {
            File archivo = new File("procesos.txt");
            Scanner lector = new Scanner(archivo);
            PriorityQueue<Proceso> procesos = new PriorityQueue<>();  // PriorityQueue

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] datos = linea.split(",");
                // Convierte texto en clases Proceso
                Proceso proceso = new Proceso(datos[0], datos[1], Integer.parseInt(datos[2]));
                System.out.println("*** Proceso identificado: " + proceso.getNombreProceso());
                // Guarda en PriorityQueue
                procesos.add(proceso);
            }
            lector.close();
            System.out.println("");
            while (!procesos.isEmpty()) {
                Proceso tem = procesos.remove(); // Elimina e Imprime datos
                System.out.println(tem.getNombreProceso()+","+tem.getNombreUsuario()+","
                        +tem.getValorNice()+", PR = "+(tem.getValorNice()+120));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo.");
        } catch (NumberFormatException e) {
            System.out.println("Error al leer el valor 'nice'.");
        }
    }
    
}
