package Strivers.SortingAlgorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,-1,-2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        // Selection sort - find the max element and place it at its correct position
        for (int i = 0; i < arr.length - 1; i++) {
            // Assume the first element of the unsorted segment as the max
            int max = 0;
            // Loop through the unsorted segment to find the max element
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            // Swap the found max element with the last element of the unsorted segment
            int temp = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[max];
            arr[max] = temp;
        }
    }
}
