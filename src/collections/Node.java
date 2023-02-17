package collections;

/**
 * Node represends data structure where save itself
 * reference to the next and previous node.
 */
public class Node<T> {
    /**
     * Data
     */
    public T data;

    /**
     * Reference to next node. (or right node)
     */
    public Node<T> next;

    /**
     * Reference to previous node. (or left node)
     */
    public Node<T> prev;

    /**
     * Creates new instance of binary node given data.
     * @param data to store in binary node.
     */
    public Node(T data) {
        this(data, null, null);
    }

    /**
     * Creates new instance of binary node given data
     * and reference to next binary node.
     * @param data to store in binary node.
     * @param next - reference of the next node.
     */
    public Node(T data, Node<T> next) {
        this(data, next, null);
    }

    /**
     * Creates new instance of binary node given data
     * and references to next and previous binary nodes.
     * @param data to store in binary node.
     * @param next - reference of the next node.
     * @param prev - reference of the previous node.
     */
    public Node(T data, Node<T> next, Node<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
