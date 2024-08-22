package Strivers.ArraysQuestions;

import java.util.Arrays;

public class RotateFromK {

    // first lets get the brute force approach for this we will just shift elements k times
    static void rotate(int[] arr, int k){
        // first get the modulo of k with n, to find the total rotation if k is greater than the length of the array
        int n = arr.length;
        k = k % n;
        // first get the n elements from n - k till n
        int[] temp = new int[k];
        int index = 0;
        for(int i = n - k; i < n; i++){
            temp[index] = arr[i];
            index++;
        }
        // after this loop all the elements present in that block will be stored
        // replace all the elements from n - k till n, with the starting elements
        int end = n - 1;
        for(int i = n - k - 1; i >= 0; i--){
            arr[end] = arr[i];
            end--;
        }

        // now replace elements from 0 to k
        for(int i = 0; i < k; i++){
            arr[i] = temp[i];
        }
    }


    static void rotateOptimize(int[] arr, int k){
        // in this approach we will first replace all the element till n - k - 1
        // and then from n - k
        // then we will reverse whole array
        int n = arr.length;
        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);
        reverse(arr, 0 , n - 1);
    }

    static void reverse(int[] arr, int start, int end){
        while (start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(arr));
//        rotate(arr, 3);
        rotateOptimize(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}

