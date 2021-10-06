package collections;

/**
 * Node represends data structure where save itself 
 * reference to the next node
 */
public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this(data, null);
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
}
