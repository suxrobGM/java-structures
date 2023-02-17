package algorithms;

public class BubbleSort {
    public static void sort(int[] array) {
        var n = array.length;
        var swapped = false;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            System.out.println("Iteration " + (i + 1) + ":");
            for (int j = 0; j < n - 1 - i; j++) {
                displayArray(array);

                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
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
        var array = new int[] {7, 12, 0, 10, 6, 3, 5, 2, 5};
        sort(array);
        System.out.println("\nSorted array:");
        displayArray(array);
    }
}
