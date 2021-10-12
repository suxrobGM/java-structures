package collections;

/**
 * Single node represends data structure where save itself 
 * reference to the next node
 */
public class Node<T> {
    /**
     * Data
     */
    public T data;

    /**
     * Reference to next node.
     */
    public Node<T> next;

    /**
     * Creates new instance of single node from given data.
     * @param data to store in node.
     */
    public Node(T data) {
        this(data, null);
    }

    /**
     * Creates new instance of single node from given data
     * and reference to next node.
     * @param data to store in node.
     * @param next - reference of the next node.
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
