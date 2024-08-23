package Strivers.BinarySearchQuestions.Medium;

public class FindMin {
    // optimal approach will be using binary search as given array is rotated
    static int findMinBS(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        int min = Integer.MAX_VALUE;
        while (start <= end){
            int mid = start + (end - start) / 2;


            if(arr[end] >= arr[start]){ // check if given array is already sorted or not
                return arr[start];
            } else if(arr[mid] >= arr[start]){ // check if my left part is sorted or not
                min = Math.min(min, arr[start]);
                start = mid + 1;
            }else{ // check if right part is sorted or not
                min = Math.min(min,arr[mid]);
                end = mid - 1;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2,3};
        System.out.println(findMin(arr));
        System.out.println(findMinBS(arr));
    }

    // brute force approach which is linear search
    static int findMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int num: arr){
            min = Math.min(min, num);
        }

        return min;
    }
}
