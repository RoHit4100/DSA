
public class OrderAgnosticBS{
    public static void main(String[] args){
        int[] arr = {335, 23, 2, 1};
        System.out.println(search(arr, 335));
    }
    
    static int search(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];
        if(isAsc){
            while(start <= end){
                int mid = start + (end - start) / 2;
                if(arr[mid] == target){
                    return mid;
                }else if(arr[mid] > target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }else{
            while(start <= end){
                int mid = start + (end - start) / 2;
                if(arr[mid] == target){
                    return mid;
                }else if(arr[mid] < target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}