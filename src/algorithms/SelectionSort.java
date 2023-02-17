package algorithms;

public class SelectionSort {
    public static void sort(int[] array) {
        var n = array.length;

        for (int i = 0; i < n - 1; i++) {
            System.out.println("Iteration " + (i + 1) + ":");

            // Find the minimum element in unsorted array
            var minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            swap(array, i, minIndex);
            displayArray(array);
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void displayArray(int[] array) {
        for (var i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        var array = new int[] {7, 10, 3, 0, 6, 5, 11, 4, 6};
        sort(array);
        System.out.println("\nSorted array:");
        displayArray(array);
    }
}
