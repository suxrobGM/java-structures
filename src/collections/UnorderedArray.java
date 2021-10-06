package collections;

/**
 * Unordered array
 */
public class UnorderedArray<T> extends AbstractArray<T> {
   	
    /**
     * Creates new instance of unordered array where default size is 10.
     */
    public UnorderedArray() {
        this(10);
    }
    
    /**
     * Creates new instance of unordered array
     * @param capacity is the size of array.
     */
    @SuppressWarnings("unchecked")
   	public UnorderedArray(int capacity) {
    	_array = (T[])new Object[capacity]; 
      	_items = 0;
    }
	
    /**
     * {@inheritDoc}
     * @implNote Time complexity: O(n)
     */
    @Override
	public int find(T item) { 
		for (int i = 0; i < _items; i++) {
			if (_array[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

    /**
     * {@inheritDoc}
     * @implNote Time complexity: O(1)
     */
    @Override
	public void insert(T item) {
		if (isFull()) {
			throw new IndexOutOfBoundsException("Array is full");
		}

		_array[_items] = item;
		_items++;
	}
	
    /**
     * {@inheritDoc}
     * @implNote Time complexity: O(n)
     */
    @Override
	public boolean delete(T item) {
		int itemIndex = -1;
		for (int i = 0; i < _items; i++) {
			if (_array[i] == item) {
				itemIndex = i;
				break;
			}
		}

		if (itemIndex == -1) {
			return false;
		}

		_array[itemIndex] = null;
		leftShift(itemIndex);
		_items--;
		return true;
	}
}
