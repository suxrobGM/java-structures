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

        for (var item : _stack) {
            System.out.println(item);
        }
    }

    @Test
    public void pop_Test() {
        var item = _stack.pop();
        assertEquals(4, _stack.size());
        assertEquals(5, item);

        for (var it : _stack) {
            System.out.println(it);
        }
    }
}
