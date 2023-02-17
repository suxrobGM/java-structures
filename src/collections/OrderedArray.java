package collections;

import java.util.Comparator;

/**
 * Ordered array
 */
public class OrderedArray<T> extends AbstractArray<T> {
    private Comparator<? super T> _comparator;

       /**
     * Creates new instance of ordered array where default size is 10.
     */
    @SuppressWarnings("unchecked")
    public OrderedArray() {
        this(10, (Comparator<T>)Comparator.naturalOrder());
    }

    /**
     * Creates new instance of ordered array with default comparator.
     */
    @SuppressWarnings("unchecked")
    public OrderedArray(int capacity) {
        this(capacity, (Comparator<T>)Comparator.naturalOrder());
    }

    /**
     * Creates new instance of ordered array
     * @param capacity is the size of array.
     */
    @SuppressWarnings("unchecked")
    public OrderedArray(int capacity, Comparator<? super T> comparator) {
        _array = (T[])new Object[capacity];
        _items = 0;
        _comparator = comparator;
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

            if(_comparator.compare(_array[middle], item) >= 1) {
                upperBound = middle - 1;
            }
            else if(_comparator.compare(_array[middle], item) <= -1) {
                lowerBound = middle + 1;
            }
            else if(_comparator.compare(_array[middle], item) == 0) {
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
    public void add(T item) {
        int startIndex = _items;
        for (int i = 0; i < _items; i++) {
            if (_comparator.compare(_array[i], item) >= 1) {
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
    public boolean remove(T item) {
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