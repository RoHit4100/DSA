package Strivers.SortingAlgorithms.SortingUsingRecursion;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        insertionSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void insertionSort(int[] arr, int index, int n){
        // we will consider index as the index of the outer loop
        if(index == n){ // this condition will make sure that we don't overrun
            return;
        }

        // now we will consider the current starting index as current index
        int j = index;
        // check if previous element is greater than the current element
        while (j > 0 && arr[j] < arr[j - 1]){
            swap(arr, j, j - 1);
            j--;
        }

        // in the end call again with increase in the index
        insertionSort(arr, index + 1, n);
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
