package Strivers.SortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {45,3,5,6,56,343,434,34,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static void sort(int[] arr){
        // in this algorithm after each iteration the max element will be at the last index
        // so, we can run inner loop till length - i
        for(int i = 0; i < arr.length - 1; i++){
            // take one boolean variable to check if any swap happened or not
            boolean swapped = false;
            // run inner loop from 1 till n - i
            // we are starting from 1 because we are going to compare it with previous elements
            for(int j = 1; j < arr.length - i; j++){
                // now ch check if current element is smaller than the previous element
                // if yes then swap those two elements
                if(arr[j] < arr[j - 1]){
                    swap(arr, j, j-1);
                    swapped = true;
                }
            }
            // after running inner loop check if any swaps happened or not
            if(!swapped){
                break;
            }
        }

    }

}
