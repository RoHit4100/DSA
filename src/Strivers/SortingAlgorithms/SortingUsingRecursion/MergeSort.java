package Strivers.SortingAlgorithms.SortingUsingRecursion;

import java.util.Arrays;

public class MergeSort {
    // merge Sort Strivers
    static void mergeSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }

        // find the mid first
        int mid = (low + high) / 2;

        // now divide the first half
        mergeSort(arr, low, mid);
        // divide the second half
        mergeSort(arr, mid + 1, high);


        // now third step is merge the two halves
        merge(arr, low, mid, high);
    }

    static void merge(int[] arr, int start, int mid, int end){
        // get the temp array for storing the elements
        int[] temp = new int[start + end + 1];

        int left = start; // start of the first half
        int right = mid + 1; // start of the second half
        int i = 0; // start of the temp

        while (left <= mid && right <= end){
            if(arr[left] <= arr[right]){
                temp[i] = arr[left];
                left++;
            }else {
                temp[i] = arr[right];
                right++;
            }
            i++;
        }

        // if at the end any of the half has some remaining elements then add those elements into the temp array
        while (left <= mid){
            temp[i] = arr[left];
            left++;
            i++;
        }

        while (right <= end){
            temp[i] = arr[right];
            right++;
            i++;
        }


        // now Add those elements into the original array
        for(int j = start; j <= end; j++){
            arr[j] = temp[j - start];
        }
    }


    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
//        mergeSort(arr, 0, arr.length);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    static void mergeSort1(int[] arr, int start, int end){
        // this condition will check how many elements do we have left, if one then just return from here
        if(end - start == 1){
            return;
        }


        // now first get the mid
        int mid = start + (end - start) / 2;
        mergeSort1(arr, start, mid);
        mergeSort1(arr, mid, end);

        // after dividing array into two parts then call the merge Method
        merger(arr, start, mid, end);
    }

    static void merger(int[] arr, int start, int mid, int end){
        // first create the end - size length array to merge those elements
        int[] mix = new int[end - start];

        // now assign the pointers for the mix array and start of the both the partitions
        int s1 = start; // this is first partitions start
        int s2 = mid; // this is second partitions start
        int i = 0; // this is mix array start


        // now run the while loop until any of the index becomes equal to its respective end
        while (s1 < mid && s2 < end){
            if(arr[s1] < arr[s2]){
                // add s1 into the mix array
                mix[i] = arr[s1++];
            }else{
                mix[i] = arr[s2++];
            }
            i++;
        }


        // now at the end if any of the partition contains the elements then just add the remaining element into the mix
        while (s1 < mid){
            mix[i++] = arr[s1++];
        }

        while (s2 < end) {
            mix[i++] = arr[s2++];
        }

        // now it is time for inplace swapping
        for(int j = 0; j < mix.length; j++){
            arr[start + j] = mix[j];
        }
    }
}
