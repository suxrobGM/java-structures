package algorithms;

public class MergeSort {
    public static void sort(int[] array) {
        sortRec(array, 0, array.length - 1);
    }

    private static void sortRec(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = left + (right-left)/2;

            // Sort first and second halves
            sortRec(array, left, middle);
            sortRec(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    /**
     * Merges two subarrays of arr[].
     * First subarray is arr[l..m]
     * Second subarray is arr[m+1..r]
     */
    private static void merge(int[] array, int left, int middle, int right)
    {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        /* Create temp arrays */
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }
            else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of leftArray[] if any */
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        /* Copy remaining elements of rightArray[] if any */
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static void displayArray(int[] array) {
        for (int i : array) {
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
