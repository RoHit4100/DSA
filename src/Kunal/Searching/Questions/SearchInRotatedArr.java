


class SearchInRotatedArr{
    public static void main(String[] args) {
        // to search in rotated array first we have to find the pivot element, which will be the highest number present in the array.
        int[] arr = {4, 5, 6, 7,8,9,11,22,33,44,455, 0, 1, 2, 3};
        System.out.println(arr[findPivot(arr)]);
        System.out.println("the index of " + 4 + " is: " + ans(arr, 4));
    }

    static int ans(int[] arr, int target){
        int pivot = findPivot(arr);
        if(pivot == target){
            return pivot;
        }
        int firstTry = bS(arr, target, 0, pivot - 1);
        if(firstTry == -1){
            return bS(arr, target, pivot + 1, arr.length);
        }
        return firstTry;
    }

    static int bS(int[] arr, int target, int start, int end){
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
        return -1;
    }


    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            // their will be four conditions to check whether or not current means the middle element is pivot or not.

            // first condition
            if(mid < arr.length && arr[mid] > arr[mid + 1]){ // first condition will be to check whether or not next element of mid is greater than mid
            // if that element is greater than means (4, 5, 6, 7, 0, 1, 2) all that will be the descending part of this array.
                return mid;
            }else if(mid > start && arr[mid] < arr[mid - 1]){
            
                return mid - 1;
            }else if(arr[start] >= arr[mid]){
                end = mid - 1;
            }else if(arr[start] <= arr[mid]){
                start = mid + 1;
            }
        }
        return arr[0];
    }
}