import java.util.Vector;
/**
 * La clase VectorHeap implementa la interfaz Priority, proporcionando un montículo
 * mínimo respaldado por un Vector. La clase acepta elementos genéricos que deben
 * implementar la interfaz Comparable para permitir la comparación y ordenación de
 * los elementos en el montículo.
 *
 * @param <E> el tipo genérico de los elementos que se van a almacenar en el montículo.
 */
public class VectorHeap<E extends Comparable<E>> implements Priority<E> {

    protected Vector<E> data; // el Vector que mantiene los datos en orden de montículo

    /**
     * Construye un montículo vacío.
     */
    public VectorHeap() {
        data = new Vector<>();
    }

    /**
     * Construye un montículo a partir de un vector existente, agregando todos los elementos
     * del vector al montículo.
     *
     * @param v el vector que contiene los elementos a agregar al montículo.
     */
    public VectorHeap(Vector<E> v) {
        data = new Vector<>(v.size()); // conocemos el tamaño final
        for (int i = 0; i < v.size(); i++) {
            add(v.get(i)); // agrega los elementos al montículo
        }
    }

    /**
     * Construye un montículo a partir de un arreglo existente, agregando todos los elementos
     * del arreglo al montículo.
     *
     * @param arr el arreglo que contiene los elementos a agregar al montículo.
     */
    public VectorHeap(E[] arr) {
        data = new Vector<>(arr.length); // conocemos el tamaño final
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]); // agrega los elementos al montículo
        }
    }

    /**
     * Devuelve el índice del padre del elemento en el índice dado.
     *
     * @param i el índice del elemento cuyo padre se desea encontrar.
     * @return el índice del padre del elemento en el índice dado.
     */
    protected static int parent(int i) {
        return (i - 1) / 2;
    }
    /////

    /**
     *
     * @param i
     * @return
     */
    protected static int left(int i) {
        return 2 * i + 1;
    }

    /**
     *
     * @param i
     * @return
     */
    protected static int right(int i) {
        return 2 * (i + 1);
    }

    /**
     *
     * @param leaf
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    /**
     *
     * @param value
     */
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

        /**

    Desciende el valor que se encuentra en la raíz de este VectorHeap, a su posición correspondiente dentro del heap.
    @param root el índice de la raíz del heap.
    */
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
        int childpos = left(root);
        if (childpos < heapSize) {
        if ((right(root) < heapSize) && ((data.get(childpos + 1)).compareTo(data.get(childpos)) < 0)) {
        childpos++;
        }
        // Afirmación: childpos indica el hijo más pequeño de los dos hijos.
        if ((data.get(childpos)).compareTo(value) < 0) {
        data.set(root, data.get(childpos));
        root = childpos; // seguir descendiendo
        } else { // se encontró la posición correcta
        data.set(root, value);
        return;
        }
        } else { // en una hoja! insertar y detenerse
        data.set(root, value);
        return;
        }
        }
    }

    /**
     *
     * @return
     */
    @Override
    public E remove() {
        E minVal = getFirst();
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) {
            pushDownRoot(0);
        }
        return minVal;
    }

    /**
     *
     * @return
     */
    @Override
    public E getFirst() {

        if (data.isEmpty()){
            return null;
        } else{
            return data.get(0);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     *
     * @return
     */

    @Override
    public int size() {
        return data.size();
    }

    /**
     *
     */
    @Override
    public void clear() {
        data.clear();
    }
}
