import static org.junit.Assert.assertEquals;

public class Tests {
    @org.junit.Test
    public void VectorHeapInsertar() { // Test para Infix to postfix
        Proceso p1 = new Proceso("vi", "juan02", 0);
        Proceso p2 = new Proceso("ls", "maria30", -20);
        VectorHeap<Proceso> prueba = new VectorHeap<>();
        assertEquals(true, prueba.isEmpty());
        assertEquals(null, prueba.getFirst());
        prueba.add(p1);
        assertEquals(false, prueba.isEmpty());
        assertEquals(p1, prueba.getFirst());
        prueba.add(p2);
        assertEquals(p2, prueba.getFirst());
    }
    @org.junit.Test
    public void VectorHeapRemove() { // Test para Infix to postfix
        Proceso p1 = new Proceso("vi", "juan02", 0);
        Proceso p2 = new Proceso("ls", "maria30", -20);
        Proceso p3 = new Proceso("ls", "maria30", -10);
        VectorHeap<Proceso> prueba = new VectorHeap<>();
        prueba.add(p1);
        prueba.add(p2);
        prueba.add(p3);
        assertEquals(p2, prueba.remove());
        assertEquals(p3, prueba.getFirst());
        assertEquals(p3, prueba.remove());
        assertEquals(p1, prueba.getFirst());

    }

}
