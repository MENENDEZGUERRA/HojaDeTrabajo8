import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LectorArchivo {

    public static void main(String[] args) {
        int op = 0;

        do{
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

    public static void LectorVH(){
        try {
            File archivo = new File("procesos.txt");
            Scanner lector = new Scanner(archivo);
            VectorHeap<Proceso> procesos = new VectorHeap<>();

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] datos = linea.split(",");
                Proceso proceso = new Proceso(datos[0], datos[1], Integer.parseInt(datos[2]));
                System.out.println("*** Proceso identificado: " + proceso.getNombreProceso());
                procesos.add(proceso);
            }
            lector.close();
            System.out.println("");
            while (!procesos.isEmpty()) {
                Proceso tem = procesos.remove();
                System.out.println(tem.getNombreProceso()+","+tem.getNombreUsuario()+","
                        +tem.getValorNice()+", PR = "+(tem.getValorNice()+120));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo.");
        } catch (NumberFormatException e) {
            System.out.println("Error al leer el valor 'nice'.");
        }
    }

    public static void LectorJCF(){
        try {
            File archivo = new File("procesos.txt");
            Scanner lector = new Scanner(archivo);
            PriorityQueue<Proceso> procesos = new PriorityQueue<>();

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] datos = linea.split(",");
                Proceso proceso = new Proceso(datos[0], datos[1], Integer.parseInt(datos[2]));
                System.out.println("*** Proceso identificado: " + proceso.getNombreProceso());
                procesos.add(proceso);
            }
            lector.close();
            System.out.println("");
            while (!procesos.isEmpty()) {
                Proceso tem = procesos.remove();
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
