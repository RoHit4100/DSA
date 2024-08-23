package Strivers.BinarySearchQuestions.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchInRotatedWithDuplicates {
    // in this case the code for rotated array will work but, we have to consider a small when mid, start and end have the
    // same element, at that time we have to reduce our search space
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
            }else if(arr.get(mid) == arr.get(start) && arr.get(mid) == arr.get(end)){ // this condition will prevent from going into
                // infinite loop.
                start++;
                end--;
            } else if(arr.get(start) <= arr.get(mid)) { // check for the left part is sorted or not
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
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2, 3, 3, 3));
        System.out.println(search(list, list.size(), 1));
    }
}
