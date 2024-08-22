package Strivers.ArraysQuestions;

import java.util.Arrays;

public class SortAnArrayWith012 {
    // here array will only have 3 elements in it, 0,1,2

    // first brute force approach will be applying any sorting algorithm like mergeSort, quickSort, bubbleSort, etc
    // second approach will be counting the number of 0, 1, 2, and replacing all actual elements by them
    // Dutch national flag algorithm
    static void sort(int[] arr){
        // here we will consider 3 pointers low, mid and high, easy algorithm watch Strivers vdo
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high && low <= high){
            // here there will be tree cases
            // when the mid is 0,1,2
            // when mid is 0
            if(arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            }else if(arr[mid] == 1){
                mid++;
            }else{
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,1,1,2,2,0,1,0,2,0,0,1,1,2,1,2,1,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sortByCounting(int[] arr){
        // first traverse through whole array and count 0, 1 and two
        int count0 = 0, count1 = 0, count2 = 0;
        System.out.println(arr.length);
        for (int num: arr){
            if(num == 0){
                count0++;
            }
            if(num == 1) {
                count1++;
            }
            if(num == 2) {
                count2++;
            }
        }
        System.out.println(" count of 0 " + count0 + " count of 1 " + count1 + " count of 2 " + count2);
        // now we have the count, just replace the indexes with the total number of count
        // for replacing with 0
        for(int i = 0; i <= count0; i++){
            arr[i] = 0;
        }
        // for replacing with 1
        for(int j = count0; j < count0 + count1; j++){
            arr[j] = 1;
        }
        // for replacing with 2
        for(int k = count0 + count1; k < arr.length; k++){
            arr[k] = 2;
        }
    }
}
