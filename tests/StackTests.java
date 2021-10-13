import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import collections.Stack;

public class StackTests {
    private Stack<Integer> _stack;

    @BeforeEach
    public void init() {
        _stack = new Stack<>();
        _stack.push(1);
        _stack.push(2);
        _stack.push(3);
        _stack.push(4);
        _stack.push(5);
    }

    @Test
    public void push_Test() {
        _stack.push(10);
        assertEquals(6, _stack.size());
        assertEquals(10, _stack.peek());
    }

    @Test
    public void pop_Test() {
        var item = _stack.pop();
        assertEquals(4, _stack.size());
        assertEquals(5, item);
    }
}
