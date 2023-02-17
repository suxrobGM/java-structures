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
        _array.add(77); // insert 10 items
        _array.add(99);
        _array.add(44);
        _array.add(55);
        _array.add(22);
        _array.add(88);
        _array.add(11);
        _array.add(00);
        _array.add(66);
        _array.add(33);
    }

    @Test
    public void insertItem_To_UnorderedArray() {
        _array.add(50);
        assertEquals(11, _array.size());
        assertThat(_array, hasItem(50));
    }

    @Test
    public void deleteItem_From_UnorderedArray() {
        _array.remove(77);
        assertEquals(9, _array.size());
        assertThat(_array, not(hasItem(77)));
        assertThat(_array, not(hasItem(50)));
    }

    @Test
    public void searchItem_In_UnorderedArray() {
        assertTrue(_array.find(11) >= 0);
        assertTrue(_array.find(12) == -1);
    }
}