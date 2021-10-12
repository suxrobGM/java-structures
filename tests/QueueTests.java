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
import collections.Queue;

public class QueueTests {
    private Queue<Integer> _queue;

    @BeforeEach
    public void init()
    {
        _queue = new Queue<>();
        _queue.endqueue(1);
        _queue.endqueue(2);
        _queue.endqueue(3);
        _queue.endqueue(4);
        _queue.endqueue(5);
    }

    @Test
    public void endqueue_Test() {
        _queue.endqueue(-1);
        assertEquals(1, _queue.peek());
        assertEquals(6, _queue.size());
    }

    @Test
    public void dequeue_Test() {
        var item = _queue.dequeue();
        assertEquals(1, item);
        assertEquals(4, _queue.size());
    }
}
