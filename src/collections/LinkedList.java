package collections;

/**
 * Single linked list
 */
public class LinkedList<T> {
    private Node<T> _head;
    
    /**
     * Creates new instance of LinkedList<T>
     */
    public LinkedList() {
        _head = null;
    }

    /**
     * Inserts data at front of the list.
     * @implNote Time complexity: O(1)
     * @param data to insert.
     */
    public void insertAtFront(T data) {
        var node = new Node<T>(data, _head);
        _head = node;
    }

    /**
     * Inserts data at rear of the list.
     * @implNote Time complexity: O(n)
     * @param data to insert.
     */
    public void insertAtBack(T data) {
        var lastNode = _head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = new Node<T>(data);
    }

    /**
     * Inserts data at specified position in the list.
     * @param data to insert.
     * @param index of the nth position to insert.
     * @exception IndexOutOfBoundsException Throws if given index is higher than length of the list.
     */
    public void insertAt(T data, int index) {
        var currentNode = _head;

        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < index - 1; i++) {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException();
            }

            currentNode = currentNode.next;
        }

        var nextNode = currentNode.next;
        currentNode.next = new Node<T>(data, nextNode);
    }

    /**
     * Checks whether list is empty or not.
     * @return True if list is empty, otherwise false.
     */
    public boolean isEmpty() {
        return _head == null;
    }
}
