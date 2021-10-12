package collections;
import java.util.Iterator;

/**
 * Single linked list
 */
public class LinkedList<T> implements Iterable<T>, EnumerableCollection {
    private Node<T> _headNode;
    private Node<T> _lastNode;
    private int _items;
    
    /**
     * Creates new instance of LinkedList<T>
     */
    public LinkedList() {
        _headNode = null;
        _lastNode = null;
    }

    /**
     * Iterator for LinkedList
     */
    class LinkedListIterator implements Iterator<T> {
        private Node<T> _current;
        private boolean _firstIteration;

        LinkedListIterator() {
            _current = LinkedList.this._headNode;
            _firstIteration = true;
        }

        @Override
        public boolean hasNext() {
            return _current != null && _current.next != null;
        }
    
        @Override
        public T next() {
            if (_firstIteration) {
                _firstIteration = false;
                return _current.data;
            }

            _current = _current.next;
            return _current.data;
        }
    }

    /**
     * Inserts data at front of the list.
     * @param data to insert.
     * @implNote Time complexity: O(1)
     */
    public void insertAtFront(T data) {
        if (_headNode == null) {
            _headNode = new Node<T>(data);
            _lastNode = _headNode;
            _items++;
            return;
        }

        var node = new Node<T>(data, _headNode);
        _headNode = node;
        _items++;
    }

    /**
     * Inserts data at rear of the list.
     * @param data to insert.
     * @implNote Time complexity: O(1)
     */
    public void insertAtBack(T data) {
        var lastNode = new Node<T>(data);
        _lastNode.next = lastNode;
        _lastNode = lastNode;
        _items++;
    }

    /**
     * Inserts data at specified position in the list.
     * @param data to insert.
     * @param index of the nth position to insert.
     * @exception IndexOutOfBoundsException Throws if given index is higher than length of the list.
     * @implNote Time complexity: O(n)
     */
    public void insertAt(T data, int index) {
        if (index < 0 || index >= _items) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0) {
            insertAtFront(data);
            return;
        }
        else if (index == _items - 1) {
            insertAtBack(data);
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
        currentNode.next = new Node<T>(data, nextNode);
        _items++;
    }

    /**
     * Searches specified data from linked list.
     * @param data to find.
     * @return position of the node in linked list. 
     * If could not find then returns -1
     * @implNote Time complexity O(n)
     */
    public int find(T data) {
        var idx = 0;

        for (var item : this) {
            if (item.equals(data)) {
                return idx;
            }
            idx++;
        }

        return -1;
    }

    /**
     * Removes the first item that occurs from the list, if it is in the list.
     * @param item to delete.
     * @implNote Time complexity O(n)
     */
    public void deleteItem(T item) {
        var index = find(item);

        if (index == -1) {
            return;
        }
        else if (index == 0) {
            deleteFront();
            return;
        }
        else if (index == _items - 1) {
            deleteBack();
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

    /**
     * Deletes node from front of the list.
     * @implNote Time complexity: O(1)
     */
    public void deleteFront() {
        if (isEmpty()) {
            return;
        }

        _headNode = _headNode.next;
        _items--;
    }

    /**
     * Deletes node from rear of the list.
     * @implNote Time complexity: O(n)
     */
    public void deleteBack() {
        if (isEmpty()) {
            return;
        }

        var currentNode = _headNode;
        while (currentNode.next != _lastNode) {
            currentNode = currentNode.next;
        }

        _lastNode = currentNode;
        _lastNode.next = null;
        _items--;
    }

    /**
     * Gets front node from the list.
     * @implNote Time complexity: O(1)
     */
    public T peekFront() {
        if (isEmpty()) {
            return null;
        }
        return _headNode.data;
    }

    /**
     * Gets last node from the list
     * @implNote Time complexity: O(1)
     */
    public T peekBack() {
        if (isEmpty()) {
            return null;
        }
        return _lastNode.data;
    }

    @Override
    public boolean isEmpty() {
        return _headNode == null;
    }

    @Override
    public int size() {
        return _items;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
}