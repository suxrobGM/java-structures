package collections;

import java.util.Iterator;

/**
 * Queue represends the data structure FIFO (first in first out)
 */
public class Queue<T> implements Iterable<T>, EnumerableCollection {
    private LinkedList<T> _list;

    /**
     * Creates new instance of queue
     */
    public Queue() {
        _list = new LinkedList<>();
    }

    /**
     * Endqueues item to queue list.
     * @param data to endqueue.
     * @implNote Time complexity: O(1)
     */
    public void endqueue(T data) {
        _list.addBack(data);
    }

    /**
     * Dequeues item from queue list.
     * @return dequeued item.
     * @implNote Time complexity: O(1)
     */
    public T dequeue() {
        return _list.removeFront();
    }

    /**
     * Gets item from the queue where stayed at front.
     */
    public T peek() {
        return _list.peekFront();
    }

    /**
     * Checks whether queue is empty or not.
     */
    @Override
    public boolean isEmpty() {
        return _list.isEmpty();
    }

    /**
     * Gets the size of queue.
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
