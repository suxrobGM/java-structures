import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import collections.OrderedArray;

public class OrderedArrayTest {

    private OrderedArray<Integer> _array;

    @BeforeEach
    private void init() {
        _array = new OrderedArray<Integer>(100);
        _array.insert(5); // insert 10 items
		_array.insert(4); 
		_array.insert(0);
		_array.insert(2);
		_array.insert(5);
		_array.insert(44);
		_array.insert(55);
		_array.insert(22);
		_array.insert(88);
		_array.insert(11);
    }


    @Test
    public void insert_Item_To_Orderedarray() {
        _array.insert(50);
        // content of the array should be {0, 2, 4, 5, 5, 11, 22, 44, 50, 55, 88}

        assertThat(_array, hasItem(50));
        assertEquals(11, _array.size());
        assertEquals(50, _array.getItemAt(8).intValue());
        assertEquals(55, _array.getItemAt(9).intValue());
    }

    @Test
    public void delete_Item_From_Orderedarray() {
        _array.delete(44);
        // content of the array should be {0, 2, 4, 5, 5, 11, 22, 55, 88}

        assertThat(_array, not(44));
        assertEquals(9, _array.size());
        assertEquals(22, _array.getItemAt(6).intValue());
        assertEquals(50, _array.getItemAt(7).intValue());
    }

    @Test
    public void search_Item_In_Orderedarray() {
        assertTrue(_array.find(11) >= 0);
        assertTrue(_array.find(12) == -1);
    }
}
