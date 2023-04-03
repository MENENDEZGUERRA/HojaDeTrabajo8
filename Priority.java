public interface Priority<E> {
    /**
     * Inserts the specified element into this priority queue.
     */
    void add(E e);

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     */
    E remove();

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     */
    E getFirst();

    /**
     * Returns true if this queue contains no elements.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this queue.
     */
    int size();

    /**
     * Removes all of the elements from this queue.
     */
    void clear();
}