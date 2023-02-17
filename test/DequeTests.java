import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import collections.Deque;

public class DequeTests {
    private Deque<Integer> _list;

    @BeforeEach
    public void init() {
        _list = new Deque<>();
        _list.addFront(1);
        _list.addFront(2);
        _list.addFront(3);
        _list.addFront(4);
        _list.addFront(5);
    }

    @Test
    public void insertAtFront() {
        _list.addFront(0);
        assertEquals(6, _list.size());
        assertEquals(0, _list.peekFront());
    }

    @Test
    public void insertAtBack() {
        _list.addBack(10);
        assertEquals(6, _list.size());
        assertEquals(10, _list.peekBack());
    }

    @Test
    public void insertAtPosition() {
        _list.insertAt(20, 0); // at front
        _list.insertAt(21, 3);
        _list.insertAt(22, _list.size() - 1); // at back

        assertEquals(8, _list.size());
        assertThat(_list, hasItem(20));

        int idx = 0;
        for (var item : _list) {
            if (idx == 0) {
                assertEquals(20, item);
            }
            else if (idx == 3) {
                assertEquals(21, item);
            }
            else if (idx == 7) {
                assertEquals(22, item);
            }
            idx++;
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 5, 6})
    public void should_Throw_Exception_On_InsertAtPosition(int index) {
        assertThrows(IndexOutOfBoundsException.class, () -> _list.insertAt(20, index));
        assertEquals(5, _list.size());
    }

    @Test
    public void deleteFromFront() {
        _list.removeFront();
        assertEquals(4, _list.size());
        assertEquals(4, _list.peekFront());
        assertThat(_list, not(hasItem(5)));
    }

    @Test
    public void deleteFromBack() {
        _list.removeBack();
        assertEquals(4, _list.size());
        assertEquals(2, _list.peekBack());
        assertThat(_list, not(hasItem(1)));
    }

    @Test
    public void deleteAnyGivenItem() {
        _list.remove(2);
        assertEquals(4, _list.size());
        assertEquals(5, _list.peekFront());
        assertEquals(1, _list.peekBack());
        assertThat(_list, not(hasItem(2)));
    }

    @Test
    public void searchTest() {
        assertTrue(_list.find(2) >= 0);
        assertTrue(_list.find(5) >= 0);
        assertTrue(_list.find(8) == -1);
    }
}
