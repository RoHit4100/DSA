import java.util.*;

class CeilingAndFloorBS{
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 15, 20, 65};
        System.out.println(Arrays.toString(getFloorAndCeil(arr, arr.length, 55)));
        int ans = search(arr, 16);
        System.out.println("and the ceiling is " + ans);
    }

    static int search(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return arr[start];
    }
        
        
    public static int[] getFloorAndCeil(int[] arr, int n, int target) {
        if(n == 1){
            return new int[] {arr[0]};
        }
        // Write your code here.
        if(arr[0] >= target){
            return new int[]{-1, arr[0]};
        }
        int start = 0;
        int end = n - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return new int[]{mid};
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return new int[]{arr[end], arr[start]};
    }
    
}