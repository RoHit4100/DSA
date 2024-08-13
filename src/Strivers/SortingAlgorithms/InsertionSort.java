package Strivers.SortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,-1,-2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr){
        // this algorithm checks whether it is smaller than previous element or not
        // if smaller, then it just moves ahead

        for(int i = 0; i < arr.length - 1; i++){
            int index = i + 1;
            while (index > 0 && arr[index] < arr[index - 1]){
                swap(arr, index, index - 1);
                index--;
            }
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
