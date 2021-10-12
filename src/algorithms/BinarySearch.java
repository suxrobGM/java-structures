package algorithms;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int lowerBound = 1;
        int upperBound = arr.length;

        while(lowerBound <= upperBound)
        {
            int middle = (lowerBound + upperBound) / 2;

            if(arr[middle] > target)
            {
                upperBound = middle - 1;
            }
            else if(arr[middle] < target)
            {
                lowerBound = middle + 1;
            }
            else if(arr[middle] == target)
            {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 10, 12, 24, -6};
        int target = 10;
        if (binarySearch(a, target)==-1) {
            System.out.println("No such a number.");
        } else {
            System.out.println("Find it");
        }
    }
}
