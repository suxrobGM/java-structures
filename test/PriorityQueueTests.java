import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import collections.PriorityQueue;

public class PriorityQueueTests {
    private PriorityQueue<Integer> _queue;

    @BeforeEach
    public void init()
    {
        _queue = new PriorityQueue<Integer>(5);
        _queue.endqueue(1, 1);
        _queue.endqueue(2, 2);
        _queue.endqueue(3, 3);
        _queue.endqueue(4, 4);
        _queue.endqueue(5, 5);
    }

    @Test
    public void endqueue_Test() {
        _queue.endqueue(-1, 6);
        assertEquals(-1, _queue.peek());
        assertEquals(5, _queue.size());
        assertEquals(5, _queue.capacity());
    }

    @Test
    public void dequeue_Test() {
        var item = _queue.dequeue();
        assertEquals(1, item);
        assertEquals(4, _queue.size());
        assertEquals(5, _queue.capacity());
    }
}
