class Main{
    public static void main(String[] args) {


    }

    public static void prueba(){
        // Creamos varios objetos Proceso
        Proceso proceso1 = new Proceso("vi", "juan02", 0);
        Proceso proceso2 = new Proceso("ls", "maria30", -20);
        Proceso proceso3 = new Proceso("firefox", "rosa20", 5);
        Proceso proceso4 = new Proceso("cat", "juan02", 5);

        // Imprimimos los procesos en el orden en que fueron creados
        System.out.println("Procesos en el orden en que se crearon:");
        System.out.println(proceso1.getNombreProceso());
        System.out.println(proceso2.getNombreProceso());
        System.out.println(proceso3.getNombreProceso());
        System.out.println(proceso4.getNombreProceso());

        // Comparamos los procesos para ver cuál tiene mayor prioridad
        int comparacion1 = proceso1.compareTo(proceso2);
        int comparacion2 = proceso3.compareTo(proceso4);

        // Imprimimos los resultados de la comparación
        System.out.println("\nResultado de la comparación 1 (proceso1 vs proceso2):");
        if (comparacion1 < 0) {
            System.out.println(proceso1.getNombreProceso() + " tiene mayor prioridad que " + proceso2.getNombreProceso());
        } else if (comparacion1 > 0) {
            System.out.println(proceso2.getNombreProceso() + " tiene mayor prioridad que " + proceso1.getNombreProceso());
        } else {
            System.out.println(proceso1.getNombreProceso() + " y " + proceso2.getNombreProceso() + " tienen la misma prioridad");
        }

        System.out.println("\nResultado de la comparación 2 (proceso3 vs proceso4):");
        if (comparacion2 < 0) {
            System.out.println(proceso3.getNombreProceso() + " tiene mayor prioridad que " + proceso4.getNombreProceso());
        } else if (comparacion2 > 0) {
            System.out.println(proceso4.getNombreProceso() + " tiene mayor prioridad que " + proceso3.getNombreProceso());
        } else {
            System.out.println(proceso3.getNombreProceso() + " y " + proceso4.getNombreProceso() + " tienen la misma prioridad");
        }
    }
    
}