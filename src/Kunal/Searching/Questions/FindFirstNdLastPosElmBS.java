
import java.util.Arrays;

class FindFirstNdLastPosElmBS{
    public static void main(String[] args){
        int[] arr = {5,7,7,7,7,7,7,7,8,8,10};
        int n = 7;
        System.out.println("The first and last position of the element " + n + " is: " + Arrays.toString(search(arr, 7)));
    }

    static int[] search(int[] arr, int target){
        int[] ans = {-1, -1};
        int start = bS(arr, target, true);
        int end = bS(arr, target, false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }
    

    static int bS(int[] arr, int target, boolean findStartIndex){
        int potentialAns = -1;
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                potentialAns = mid;
                if(findStartIndex){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return potentialAns;
    }
    
}