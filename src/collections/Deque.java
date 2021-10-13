package collections;

/**
 * Deque represents a doubly linked list data structure.
 */
public class Deque<T> extends AbstractLinkedList<T> {

    /**
     * Creates new instance of deque.
     */
    public Deque() {
        super();
    }

    /**
     * Inserts data at front of the list.
     * @param data to insert.
     * @implNote Time complexity: O(1)
     */
    @Override
    public void addFront(T data) {
        var newNode = new Node<T>(data);

        if (isEmpty()) {
            _headNode = _lastNode = newNode;
            _items++;
            return;
        }

        newNode.next = _headNode;
        _headNode.prev = newNode;
        _headNode = newNode;
        _items++;
    }

    /**
     * Inserts data at rear of the list.
     * @param data to insert.
     * @implNote Time complexity: O(1)
     */
    @Override
    public void addBack(T data) {
        if (isEmpty()) {
            addFront(data);
            return;
        }

        var newNode = new Node<T>(data);
        newNode.prev = _lastNode;
        _lastNode.next = newNode;
        _lastNode = newNode;
        _items++;
    }

    /**
     * Inserts data at specified position in the list.
     * @param data to insert.
     * @param index of the nth position to insert.
     * @exception IndexOutOfBoundsException Throws if given index is higher than length of the list.
     * @implNote Time complexity: O(n)
     */
    @Override
    public void insertAt(T data, int index) {
        if (index < 0 || index >= _items) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0) {
            addFront(data);
            return;
        }
        else if (index == _items - 1) {
            addBack(data);
            return;
        }

        var currentNode = _headNode;

        for (int i = 1; i < index; i++) {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException();
            }

            currentNode = currentNode.next;
        }

        var nextNode = currentNode.next;
        currentNode.next = new Node<T>(data, nextNode, currentNode);
        _items++;
    }

    /**
     * Deletes node from front of the list.
     * @return data of the removed node. If list is empty then returns null.
     * @implNote Time complexity: O(1)
     */
    @Override
    public T removeFront() {
        if (isEmpty()) {
            return null;
        }

        var firstNode = _headNode;

        if (_items == 1) {
            _headNode = _lastNode = null;
            _items--;
            return firstNode.data;
        }

        _headNode = _headNode.next;
        _headNode.prev = null;
        _items--;
        return firstNode.data;
    }

    /**
     * Deletes node from rear of the list.
     * @return data of the removed node. If list is empty then returns null.
     * @implNote Time complexity: O(1)
     */
    @Override
    public T removeBack() {
        if (isEmpty()) {
            return null;
        }

        var lastNode = _lastNode;

        if (_items == 1) {
            _headNode = _lastNode = null;
            _items--;
            return lastNode.data;
        }

        _lastNode = _lastNode.prev;
        _lastNode.next = null;
        _items--;
        return _lastNode.data;
    }

    /**
     * Removes the first occured item from the list, if it contains in the list.
     * @param item to delete.
     * @implNote Time complexity O(n)
     */
    @Override
    public void remove(T item) {
        var index = find(item);

        if (index == -1) {
            return;
        }
        else if (index == 0) {
            removeFront();
            return;
        }
        else if (index == _items - 1) {
            removeBack();
            return;
        }

        var currentNode = _headNode;

        for (int i = 1; i < index; i++) {
            if (currentNode == null) {
                return;
            }

            currentNode = currentNode.next;
        }

        var nextNode = currentNode.next.next;
        currentNode.next = nextNode;
        _items--;
    }
}
