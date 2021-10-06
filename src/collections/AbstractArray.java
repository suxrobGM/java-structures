package collections;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Abstract array
 */
public abstract class AbstractArray<T> implements Iterable<T> {
    protected T[] _array;
    protected int _items;  // actual number of items in the array.

    /**
     * Inserts element to end of the array.
     * @param item item to add in the array.
     * @exception IndexOutOfBoundsException Throws if array is full.
     */
    public abstract void insert(T data);

    /**
     * Deletes first occured element from array.
     * @param item to delete
     * @return True if item was deleted successfully, otherwise false.
     */
    public abstract boolean delete(T item);

    /**
     * Searchs element in array
     * @param item to search in array
     * @return index of found element. 
     * If could not find then returns -1
     */
    public abstract int find(T item);

    /**
     * Get item by index
     */
    public T getItemAt(int index) {
        return _array[index];
    }

    /**
     * Checks wheter array is full or not.
     * @return True if array is full, otherwise false.
     */
	public boolean isFull() {
		return _items == _array.length - 1;
	}
	
    /**
     * Checks arrays is empty or not.
     * @return True if array is empty, otherwise false.
     */
	public boolean isEmpty() {
		return _items == 0;
	}
    
    /**
     * Gets the length of the array.
     */
    public int size() {
        return _items;
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.stream(_array).iterator();
    }
    
    /**
     * Moves items to left side from index of the specified item to index of the last item.
     * @implNote Time complexity: O(n)
     * @param startIndex
     */
	protected final void leftShift(int startIndex) {
		T firstItem = _array[startIndex];
		for (int i = startIndex; i < _items; i++) {
			_array[i] = _array[i+1];
		}
		_array[_items - 1] = firstItem;
	}

    /**
     * Moves items to right side from index of the last item to index of the specified item.
     * @implNote Time complexity: O(n)
     * @param startIndex
     */
	protected final void rightShift(int startIndex) {
		T lastItem = _array[_items - 1];
		for (int i = _items; i > startIndex; i--) {
			_array[i] = _array[i-1];
		}
		_array[startIndex] = lastItem;
	}
}
