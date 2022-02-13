package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        quicksort(intArray, 0, intArray.length);

        System.out.println(Arrays.toString(intArray));
    }

    public static void quicksort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        // return correct position of the pivot
        int pivotIndex = partition(input, start, end);
        //quick sort left sub array
        quicksort(input, start, pivotIndex);
        // quick sort right sub array
        quicksort(input, pivotIndex + 1, end);
    }

    private static int partition(int[] input, int start, int end) {
        // using first element as the pivot
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j) {

            //note: empty loop body for decrementing j
            while (i < j && input[--j] >= pivot) ;
            if (i < j) {
                input[i] = input[j];
            }

            //note: empty loop body for incrementing i
            while (i < j && input[++i] <= pivot) ;
            if (i < j) {
                input[j] = input[i];
            }
        }
        input[j] = pivot;
        return j;
    }
}
