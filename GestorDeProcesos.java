public class GestorDeProcesos {
    
    private VectorHeap<Proceso> colaPrioridad;
    
    public GestorDeProcesos() {
        colaPrioridad = new VectorHeap<>();
    }
    
    public void agregarProceso(Proceso proceso) {
        colaPrioridad.add(proceso);
    }
    
    public void atenderProcesos() {
        while (!colaPrioridad.isEmpty()) {
            Proceso proceso = colaPrioridad.remove();
            System.out.println("Atendiendo proceso: " + proceso);
            try {
                Thread.sleep(1000); // Simula el tiempo de atención del proceso por el CPU
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("No hay más procesos por atender.");
    }
}
