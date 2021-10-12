package collections;

public class Queue<T> implements EnumerableCollection {
    private T[] _array;
    private int _items;
    private int _capacity;

    public void endqueue(T data) {
        
    }

    public T dequeue() {
        return null;
    }

    public T peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return _items == 0;
    }

    @Override
    public int size() {
        return _items;
    }
    
}
