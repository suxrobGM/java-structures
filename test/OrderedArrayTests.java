import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import collections.OrderedArray;

public class OrderedArrayTests {

    private OrderedArray<Integer> _array;

    @BeforeEach
    private void init() {
        _array = new OrderedArray<Integer>(100);
        _array.add(5); // insert 10 items
        _array.add(4);
        _array.add(0);
        _array.add(2);
        _array.add(5);
        _array.add(44);
        _array.add(55);
        _array.add(22);
        _array.add(88);
        _array.add(11);
    }

    @Test
    public void insertItem_To_OrderedArray() {
        _array.add(50);
        // content of the array should be {0, 2, 4, 5, 5, 11, 22, 44, 50, 55, 88}

        assertThat(_array, hasItem(50));
        assertEquals(11, _array.size());
        assertEquals(50, _array.getItemAt(8).intValue());
        assertEquals(55, _array.getItemAt(9).intValue());
    }

    @Test
    public void deleteItem_From_OrderedArray() {
        _array.remove(44);
        // content of the array should be {0, 2, 4, 5, 5, 11, 22, 55, 88}

        assertThat(_array, not(44));
        assertEquals(9, _array.size());
        assertEquals(22, _array.getItemAt(6).intValue());
        assertEquals(55, _array.getItemAt(7).intValue());
    }

    @Test
    public void searchItem_In_OrderedArray() {
        assertTrue(_array.find(11) >= 0);
        assertTrue(_array.find(12) == -1);
    }
}
