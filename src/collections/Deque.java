package collections;

import java.util.Iterator;

/**
 * Deque represents a doubly linked list data structure.
 */
public class Deque<T> implements EnumerableCollection, Iterable<T> {
    private BinaryNode<T> _headNode;
    private BinaryNode<T> _lastNode;
    private int _items;

    /**
     * Creates new instance of deque.
     */
    public Deque() {
        _headNode = null;
        _lastNode = null;
        _items = 0;
    }

    /**
     * Iterator for Deque
     */
    class DequeIterator implements Iterator<T> {
        private BinaryNode<T> _current;
        private boolean _firstIteration;

        DequeIterator() {
            _current = Deque.this._headNode;
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
    public void addFront(T data) {
        var newNode = new BinaryNode<T>(data);

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
    public void addBack(T data) {
        if (isEmpty()) {
            addFront(data);
            return;
        }

        var newNode = new BinaryNode<>(data);
        newNode.prev = _lastNode;
        _lastNode.next = newNode;
        _lastNode = newNode;
        _items++;
    }

    /**
     * Deletes node from front of the list.
     * @implNote Time complexity: O(1)
     * @return data of the removed node. If list is empty then returns null.
     */
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
     * @implNote Time complexity: O(1)
     * @return data of the removed node. If list is empty then returns null.
     */
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
     * Gets the front node from the list.
     * @implNote Time complexity: O(1)
     */
    public T peekFront() {
        if (isEmpty()) {
            return null;
        }
        return _headNode.data;
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
        currentNode.next = new BinaryNode<T>(data, nextNode, currentNode);
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
     * Removes the first occured item from the list, if it contains in the list.
     * @param item to delete.
     * @implNote Time complexity O(n)
     */
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

    /**
     * Gets the last node from the list.
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
        return new DequeIterator();
    }

    @Override
    public String toString() {
        var strBuilder = new StringBuilder();
        var count = 0;
        strBuilder.append("[");

        for(var item : this) {
            count++;
            strBuilder.append(item.toString());
            if (count != _items) {
                strBuilder.append(", ");
            }
        }

        strBuilder.append("]");
        return strBuilder.toString();
    }
}
