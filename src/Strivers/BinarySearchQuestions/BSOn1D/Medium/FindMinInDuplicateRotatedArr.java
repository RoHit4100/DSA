package Strivers.BinarySearchQuestions.BSOn1D.Medium;

public class FindMinInDuplicateRotatedArr {

    static int findMinBS(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        int min = Integer.MAX_VALUE;
        while (start <= end){
            int mid = start + (end - start) / 2;

            if(arr[start] == arr[mid] && arr[end] == arr[mid] || arr[start] == arr[end]){ // check if start and end is equal or not
                // they will be equal in the case of the duplicates
                start++;
                end--;
            }else if(arr[end] > arr[start]){ // check if given array is already sorted or not
                return arr[start];
            }else if(arr[mid] >= arr[start]){ // check if my left part is sorted or not
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
        int[] arr = {5,5,5,0,0,1,2,5,5,5,5,5};
        System.out.println(findMinBS(arr));
    }
}
