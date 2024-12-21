// Merge Sort Implementation in Java
public class MergeSort {
    // Function to merge two subarrays
    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = array[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Recursive function to implement merge sort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort the first and second halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }
}

// Quick Sort Implementation in Java
class QuickSort {
    // Partition function used by quick sort
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                // Swap elements
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap pivot element with the element at i+1
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Recursive function to implement quick sort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Find the partitioning index
            int pi = partition(array, low, high);

            // Recursively sort elements before and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
}

// Example usage
class SortExample {
    public static void main(String[] args) {
        int[] array1 = {12, 11, 13, 5, 6, 7};
        MergeSort.mergeSort(array1, 0, array1.length - 1);
        System.out.println("Sorted array using Merge Sort: " + java.util.Arrays.toString(array1));

        int[] array2 = {10, 7, 8, 9, 1, 5};
        QuickSort.quickSort(array2, 0, array2.length - 1);
        System.out.println("Sorted array using Quick Sort: " + java.util.Arrays.toString(array2));
    }
}

// Note:
// Part 1: The Merge Sort implementation starts at the class MergeSort and ends at the end of the mergeSort method.
// Part 2: The Quick Sort implementation starts at the class QuickSort and ends at the end of the quickSort method.

// Author: Ahmet C Sekerci
