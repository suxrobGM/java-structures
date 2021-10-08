import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import collections.UnorderedArray;

class UnorderedArrayTests {

    private UnorderedArray<Integer> _array;

    @BeforeEach
    private void init() {
        _array = new UnorderedArray<Integer>(100);
        _array.insert(77); // insert 10 items
		_array.insert(99);
		_array.insert(44);
		_array.insert(55);
		_array.insert(22);
		_array.insert(88);
		_array.insert(11);
		_array.insert(00);
		_array.insert(66);
		_array.insert(33);
    }

    @Test
    public void insert_Item_To_Unorderedarray() {
        _array.insert(50);
        assertEquals(11, _array.size());
        assertThat(_array, hasItem(50));
    }

    @Test
    public void delete_Item_From_Unorderedarray() {
        _array.delete(77);
        assertEquals(9, _array.size());
        assertThat(_array, not(hasItem(77)));
        assertThat(_array, not(hasItem(50)));
    }

    @Test
    public void search_Item_In_Unorderedarray() {
        assertTrue(_array.find(11) >= 0);
        assertTrue(_array.find(12) == -1);
    }
}