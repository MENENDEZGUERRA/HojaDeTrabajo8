public class Proceso implements Comparable<Proceso> {

    private String nombreProceso;
    private String nombreUsuario;
    private int valorNice;

    /**
     * @param nombreProceso
     * @param nombreUsuario
     * @param valorNice
     */

    public Proceso(String nombreProceso, String nombreUsuario, int valorNice) {
        this.nombreProceso = nombreProceso;
        this.nombreUsuario = nombreUsuario;
        this.valorNice = valorNice;
    }

    /**
     *
     * @return
     */
    public String getNombreProceso() {
        return nombreProceso;
    }

    /**
     *
     * @return
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     *
     * @return
     */
    public int getValorNice() {
        return valorNice;
    }

    /**
     * Utiliza la implementacion de Comparable y reescribe el método
     * para ser utilzado en VectorHeap
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Proceso o) {
        // Comparar los procesos por su valorNice (orden ascendente)
        return Integer.compare(this.valorNice, o.valorNice);
    }


}
