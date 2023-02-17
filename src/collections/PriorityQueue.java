package collections;

/**
 * PriorityQueue
 */
public class PriorityQueue<T> implements CountableCollection {
    private Task<T>[] _heap;
    private int _capacity;
    private int _size;

    /**
     * Creates a new instance of priority queue
     * @param capacity Queue size that can contain the maximum number of elements
     */
    @SuppressWarnings("unchecked")
    public PriorityQueue(int capacity) {    
        this._capacity = capacity + 1;
        _heap = new Task[this._capacity];
        _size = 0;
    }

    public void endqueue(T data, int priority) {
        var task = new Task<>(data, priority);

        _size++;
        _heap[_size] = task;
        var pos = _size;

        while (pos != 1 && task.priority > _heap[pos/2].priority) {
            _heap[pos] = _heap[pos/2];
            pos /=2;
        }
        _heap[pos] = task;
    }

    public T dequeue() {
        var parent = 1;
        var child = 2;

        if (isEmpty()) {
            return null;
        }
 
        var task = _heap[1];
        var temp = _heap[_size];
        _size--;

        while (child <= _size) {
            if (child < _size && _heap[child].priority < _heap[child + 1].priority) {
                child++;
            }  
            if (temp.priority >= _heap[child].priority) {
                break;
            }

            _heap[parent] = _heap[child];
            parent = child;
            child *= 2;
        }

        _heap[parent] = temp;
        return task.job;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
    
        return _heap[1].job;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        _heap = new Task[_capacity];
        _size = 0;
    }

    public int capacity() {
        return _capacity;
    }

    public boolean isFull() {
        return _size == _capacity - 1;
    }

    @Override
    public boolean isEmpty() {
        return _size == 0;
    }

    @Override
    public int size() {
        return _size;
    }
}