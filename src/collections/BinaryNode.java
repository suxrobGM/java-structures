package collections;

/**
 * Binary node represends data structure where save itself 
 * reference to the next node and previous node;
 */
public class BinaryNode<T> extends Node<T> {
    
    /**
     * Reference to previous node.
     */
    public BinaryNode<T> prev;

    /**
     * Creates new instance of binary node given data.
     * @param data to store in binary node.
     */
    public BinaryNode(T data) {
        this(data, null, null);
    }

    /**
     * Creates new instance of binary node given data
     * and reference to next binary node.
     * @param data to store in binary node.
     * @param next - reference of the next node.
     */
    public BinaryNode(T data, BinaryNode<T> next) {
        this(data, next, null);
    }
    
    /**
     * Creates new instance of binary node given data
     * and references to next and previous binary nodes.
     * @param data to store in binary node.
     * @param next - reference of the next node.
     * @param prev - reference of the previous node.
     */
    public BinaryNode(T data, BinaryNode<T> next, BinaryNode<T> prev) {
        super(data, next);
        this.prev = prev;
    }
}
