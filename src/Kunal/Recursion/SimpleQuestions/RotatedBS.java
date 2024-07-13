class RotatedBS{
    public static void main(String[] args){
        int[] arr = {3,1};
        int target = 1;
        System.out.println("The index of " + target + " is: " + search(arr, target));
    }
    

    static int search(int [] arr, int target){
        return helper(arr, target, 0, arr.length - 1); 
    }

    static int helper(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }

        int mid = start + (end - start) / 2;
        // now I have to check cases for element to be present is which side.
        if(arr[mid] == target){
            return mid;
        }if(arr[start] <= arr[mid]){
            if(target >= arr[start] && target <= arr[mid]){
                return helper(arr, target, start, mid - 1);
            }else{
                return helper(arr, target, mid + 1, end);
            }
        }else if(target > arr[mid] && target <= arr[end]){
            return helper(arr, target, mid + 1, end);
        }else{
            return helper(arr, target, start, mid - 1);
        }
    }
}