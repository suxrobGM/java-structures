import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import collections.UnorderedArray;

class UnorderedArrayTest {

    private UnorderedArray<Integer> _array;
    private static <T> void display(UnorderedArray<T> arr) {
        for (var item : arr) {
            if (item != null) {
                System.out.printf(item.toString() + " ");   
            }
        }
        System.out.println();
    }

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
    public void insertTest() {
        //Assertions.assertEquals(_array, actual);
    }

    public static void main(String[] args) {
		int maxSize = 100;
		var arr = new UnorderedArray<Integer>(maxSize);

		arr.insert(77); // insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

        display(arr);

		int searchKey = 35; // search for item
		if (arr.find(searchKey) >= 0)
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can't find " + searchKey);

		// arr.delete(00); // delete 3 items
		arr.delete(55);
		arr.delete(99);
        display(arr);
	}
}