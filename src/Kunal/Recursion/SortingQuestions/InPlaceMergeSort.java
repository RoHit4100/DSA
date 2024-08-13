package Kunal.Recursion.SortingQuestions;

import java.util.Arrays;


class InPlaceMergeSort{
    public static void main(String[] args){
        int[] arr = {4, 1, 3, 9, 7};
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int start, int end){
        if(end - start == 1){
            return;
        }

        int mid = (start + end)/ 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    static void mergeInPlace(int[] arr, int start, int mid, int end){
        int[] mix = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while(i < mid && j < end){
            if(arr[i] < arr[j]){
                mix[k++] = arr[i++];
            }else{
                mix[k++] = arr[j++];
            }
        }

        // in the end if any array has remaining elements then those elements are added into the mix
        while(i < mid){
            mix[k++] = arr[i++];
        }
        while(j < end){
            mix[k++] = arr[j++];
        }

        // now we have to copy all the number into arr, from mix
        for(int l = 0; l < mix.length; l++){
            arr[start + l] = mix[l];
        }
    }

}