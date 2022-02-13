package sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(intArray, 0, intArray.length);

        System.out.println(Arrays.toString(intArray));
    }

    public static void mergeSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    private static void merge(int[] input, int start, int mid, int end) {
        // if the last element in the left partition is smaller than first in the right
        // then we ended because left and right partitions are sorted
        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }
        // if we have left some elements in the right array then we can leave them
        // because everything in the right is greater than in sorted temp array,
        // and when overriding temp over original the remaining (that we
        // didn't include in temp array) will stay untouched which is correct
        // { 32, 34 }, { 33, 36 } unsorted -> 36 at index = 3 in orig array
        // { 32, 33, 34, 36} sorted -> 36 at index = 3 when sorted.

        // but it won't work in case with remaining elements from left array, so we
        // need to copy them to original input array at the end after temp array.
        // {7, 55}, {1, -22}
        // after while iterations we have {-22, 1, 7} and we need to add 55 at the end,
        // but we won't add this element to temp array but rather copy over original input for
        // better optimization.
        System.arraycopy(input, i, input, start + tempIndex, mid - i);

        // copy sorted temp array over input array
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}