import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import collections.LinkedList;

class LinkedListTest {
    
    @Test
    public void insertAtFrontTest() {
        var list = new LinkedList<Integer>();
        list.insertAtFront(1);
        Assertions.assertTrue(!list.isEmpty());
    }
}
