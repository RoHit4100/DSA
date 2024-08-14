package Strivers.SortingAlgorithms.SortingUsingRecursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        quickSSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    /*
    quick sort is about sorting element in the chunks,
    so basically we first select a pivot element
    and perform recursive function over those chunks

    what we do in the recursion function, is important
    we basically put all the elements which are lesser than the pivot element,on the left side of the pivot
    and all the elements which are greater than the pivot element on the right side of the pivot, this thing
    is performed recursively
     */
    static void quickSSort(int[] arr, int low, int high){
        // base condition
        if(low >= high){
            return;
        }

        // now first find the pivot, pivot can be any number in the array, but we will get the middle
        int mid = low + (high - low) / 2;
        int pivot = arr[mid];
        // now get the pointer to move in the array
        int start = low;
        int end = high;

        while (start <= end){
            // now here we will search into the array until we find the violation into the array,
            // which means whenever we find a smaller element on the right side of the array
            // and whenever we find greater element into the left side of the array


            // first check
            while (pivot > arr[start]){
                start++;
            }

            // second check
            while (pivot < arr[end]){
                end--;
            }

            // whenever we broke out of this two loop we know that we have found the violation
            // now swap elements present at those indexes
            // and also check that start has to lesser than the end
            if(start <= end){
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        // now we know we have put pivot on its correct index, now we have to perform this thing for other recursion calls also
        quickSSort(arr, low, end);
        quickSSort(arr, start, high);
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
