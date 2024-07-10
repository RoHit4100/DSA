package Kunal.Searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 8, 22, 32, 335};
        System.out.println(search(arr, 335));
    }

    static int search(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
