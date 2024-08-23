package Strivers.BinarySearchQuestions.Easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchInRotatedArray {
    // this is the optimal approach which uses the binary search algorithm
    public static int search(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        int start = 0;
        if(k == arr.get(start)){
            return start;
        }
        int end = n - 1;
        if(k == arr.get(end)){
            return end;
        }

        while(start <= end){
            int mid = start + (end - start) / 2;

            // now check for the conditions
            if(arr.get(mid) == k){
                return mid;
            }else if(arr.get(start) <= arr.get(mid)) { // check for the left part is sorted or not
                // in this case my left part is sorted
                // check whether the k lies into the left part
                if(arr.get(start) <= k && arr.get(mid) > k){
                    // then check into the left part of array
                    end = mid - 1;
                }else{
                    // check into the right part
                    start = mid + 1;
                }
            }else { // if we are here means the right part is sorted
                // now check k lies into right part or not
                if(k > arr.get(mid) && k <= arr.get(end)){
                    // then check into sorted part
                    start = mid + 1;
                }else{
                    // check into unsorted part
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(8, 9, 4, 5));
        System.out.println(search(list, list.size(), 8));
        System.out.println(linearSearch(list,list.size(), 8));
    }

    // Brute force approach will use the linear search
    static int linearSearch(ArrayList<Integer> arr, int n, int k){
        for(int i = 0; i < n; i++){
            if(arr.get(i) == k){
                return i;
            }
        }
        return -1;
    }
}
