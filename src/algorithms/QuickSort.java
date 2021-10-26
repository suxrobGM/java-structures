package algorithms;

public class QuickSort {
    public static void sort(int[] array) {
        sortRec(array, 0, array.length - 1);
    }

    private static void sortRec(int[] array, int start, int end) {
        if(start < end){
            int partition = partition(array, start, end); // find the correct position for the pivot

            sortRec(array, start, partition-1); // recursively call the quick sort for the left had side of the pivot
            sortRec(array, partition+1, end);  // sort right hand side of the pivot
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end]; // choose the last element as pivot
        int swapPosition = start;
        System.out.println("\npivot: " + pivot);

        for(int i = start; i <= end - 1; i++){
            /**
             * if value at i is less than pivot,
             * swap the ith position with the swapPosition and incriment the swapPosition to next element.
             */
            if(array[i] <= pivot){
                swap(array, swapPosition, i);
                swapPosition++;
            }

            displayArray(array);
        }

        /* At the end swap the pivot with the swapposition.
        This will move the pivot element to sorted position */
        swap(array, swapPosition, end);
        displayArray(array);
        return swapPosition;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
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
