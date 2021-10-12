package collections;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

public class Stack<T> implements Iterable<T>, EnumerableCollection {
    private T[] _array;
    private int _items;
    private int _capacity;
    
    public Stack() {
        this(100); // default capacity
    }

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        _capacity = capacity; // initial capacity
        _array = (T[])new Object[_capacity];
        _items = 0;
    }

    public void push(T data) {
        if (_items - 1 == _capacity) {
            growArray();
        }

        _array[_items++] = data;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        return _array[--_items];
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return _array[_items - 1];
    }
    
    @SuppressWarnings("unchecked")
    private void growArray() {
        _capacity *= 2;
        var temp = _array;
        _array = (T[])new Object[_capacity];

        for (int i = 0; i < temp.length; i++) {
            _array[i] = temp[i];
        }
    }

    @Override
    public boolean isEmpty() {
        return _items == 0;
    }

    @Override
    public int size() {
        return _items;
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.stream(_array).limit(_items).iterator();
    }
}
