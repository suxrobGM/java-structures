package algorithms;

public class InsertionSort {
    public static void sort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
            displayArray(array);
        }
    }

    private static void displayArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        var array = new int[] {7, 12, 0, 10, 6, 3, 5, 2, 5};
        sort(array);
        System.out.println("\nSorted array:");
        displayArray(array);
    }
}
