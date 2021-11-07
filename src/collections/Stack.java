package collections;

import java.util.Iterator;

/**
 * Stack represents the LIFO (last in first out) data structure.
 */
public class Stack<T> implements Iterable<T>, CountableCollection {
    private LinkedList<T> _list;

    /**
     * Creates new instance of stack.
     */
    public Stack() {
        _list = new LinkedList<>();
    }

    /**
     * Adds item to the top of stack.
     * @param data
     */
    public void push(T data) {
        _list.addFront(data);
    }

    /**
     * Deletes the top item from stack.
     * @return deleted item
     */
    public T pop() {
        return _list.removeFront();
    }

    /**
     * Gets value of the top item in stack.
     * @implNote Time complexity: O(1)
     */
    public T peek() {
        return _list.peekFront();
    }

    /**
     * Checks whether stack is empty or not.
     * @implNote Time complexity: O(1)
     */
    @Override
    public boolean isEmpty() {
        return _list.isEmpty();
    }

    /**
     * Gets the size of stack.
     * @implNote Time complexity: O(1)
     */
    @Override
    public int size() {
        return _list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return _list.iterator();
    }
}
