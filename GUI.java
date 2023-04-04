import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {

    public static void main(String[] args) {
        // Crear ventana
        JFrame ventana = new JFrame("Mi ventana");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear panel para agregar elementos
        JPanel panel = new JPanel();

        // Crear botón para agregar elementos al VectorHeap
        JButton botonVH = new JButton("Agregar al VectorHeap");
        botonVH.addActionListener(e -> LectorArchivo.LectorVH()); // Llama al método LectorVH de la clase LectorArchivo
        panel.add(botonVH);

        // Crear botón para agregar elementos al PriorityQueue de JCF
        JButton botonJCF = new JButton("Agregar al PriorityQueue de JCF");
        botonJCF.addActionListener(e -> LectorArchivo.LectorJCF()); // Llama al método LectorJCF de la clase LectorArchivo
        panel.add(botonJCF);

        // Agregar panel a la ventana
        ventana.add(panel);

        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}
