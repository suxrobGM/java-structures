package collections;

import java.util.Iterator;

public abstract class AbstractLinkedList<T> implements CountableCollection, Iterable<T> {
    protected Node<T> _headNode;
    protected Node<T> _lastNode;
    protected int _items;

    /**
     * Creates new instance of LinkedList<T>
     */
    protected AbstractLinkedList() {
        _headNode = null;
        _lastNode = null;
        _items = 0;
    }

    /**
     * Iterator for LinkedList
     */
    class LinkedListIterator implements Iterator<T> {
        private Node<T> _current;
        private boolean _firstIteration;

        LinkedListIterator() {
            _current = AbstractLinkedList.this._headNode;
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
     */
    public abstract void addFront(T data);

    /**
     * Inserts data at rear of the list.
     * @param data to insert.
     * @implNote Time complexity: O(1)
     */
    public abstract void addBack(T data);

    /**
     * Inserts data at specified position in the list.
     * @param data to insert.
     * @param index of the nth position to insert.
     * @exception IndexOutOfBoundsException Throws if given index is higher than length of the list.
     */
    public abstract void insertAt(T data, int index);

    /**
     * Deletes node from front of the list.
     * @return data of the removed node. If list is empty then returns null.
     */
    public abstract T removeFront();

    /**
     * Deletes node from rear of the list.
     * @return data of the removed node. If list is empty then returns null.
     */
    public abstract T removeBack();

    /**
     * Removes the first occured item from the list, if it contains in the list.
     * @param item to delete.
     */
    public abstract void remove(T item);

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
     * Gets the last node from the list
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
