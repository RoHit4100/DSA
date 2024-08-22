package Strivers.BinarySearchQuestions.Easy;

import java.util.Arrays;

public class CeilAndFloorInUnsortedArr {
    public static void main(String[] args) {
        int[] arr = {36, 82, 88, 56, 21, 17, 73, 86};
        System.out.println(Arrays.toString(getFloorAndCeil(17, arr)));
    }

    public static int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);

        int floor = -1;
        int ceil = -1;

        // now perform the binary search and find the floor and ceil
        int start = 0;
        int n = arr.length;
        int end = n - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == x){
                floor = arr[mid];
                ceil = arr[mid];
                break;
            }else if(arr[mid] < x){
                floor = arr[mid];
                start = mid + 1;
            }else{
                ceil = arr[mid];
                end = mid - 1;
            }
        }

        return new int[] {floor, ceil};
    }
}
