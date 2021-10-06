package collections;

/**
 * Ordered array
 */
public class OrderedArray<T extends Comparable<T>> extends AbstractArray<T> {
   	
   	/**
     * Creates new instance of ordered array where default size is 10.
     */
    public OrderedArray() {
        this(10);
    }
    
    /**
     * Creates new instance of ordered array
     * @param capacity is the size of array.
     */
    @SuppressWarnings("unchecked")
   	public OrderedArray(int capacity) {
    	_array = (T[])new Object[capacity]; 
      	_items = 0;
    }

    /**
     * {@inheritDoc}.
     * Finds elements using binary search.
     * @implNote Time complexity: O(log(n))
     */
    @Override
   	public int find(T item) {
		int lowerBound = 0;
        int upperBound = _items;
		int middle = (lowerBound + upperBound) / 2;
		
        while(lowerBound <= upperBound) {
            middle = (lowerBound + upperBound) / 2;

            if(_array[middle].compareTo(item) >= 1) {
                upperBound = middle - 1;
            }
            else if(_array[middle].compareTo(item) <= -1) {
                lowerBound = middle + 1;
            }
            else if(_array[middle].compareTo(item) == 0) {
                return middle;            
            }
        }
		return -1;
    }
   
    /**
     * {@inheritDoc}
     * @implNote Time complexity: O(n)
     */
    @Override
   	public void insert(T item) {
		int startIndex = _items;
		for (int i = 0; i < _items; i++) {
			if (_array[i].compareTo(item) >= 1) {
				startIndex = i;
				break;
			}
		}

		_items++;
		rightShift(startIndex);
		_array[startIndex] = item;
    }
   
    /**
     * {@inheritDoc}
     * @implNote Time complexity: O(n)
     */
    @Override
   	public boolean delete(T item) {
    	int itemIndex = find(item);
		
		if (itemIndex == -1) {
			return false;
		}

		_array[itemIndex] = null;
		leftShift(itemIndex);
		_items--;
		return true;
    }
}