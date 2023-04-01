public class Proceso implements Comparable<Proceso> {
    private String nombreProceso;
    private String nombreUsuario;
    private int valorNice;

    public Proceso(String nombreProceso, String nombreUsuario, int valorNice) {
        this.nombreProceso = nombreProceso;
        this.nombreUsuario = nombreUsuario;
        this.valorNice = valorNice;
    }

    public String getNombreProceso() {
        return nombreProceso;
    }
  
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getValorNice() {
        return valorNice;
    }

    @Override
    public int compareTo(Proceso o) {
        // Comparar los procesos por su valorNice (orden ascendente)
        return Integer.compare(this.valorNice, o.valorNice);
    }


}
