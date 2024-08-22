package Strivers.Arrays;

public class ReversePairs {
    // optimal approach uses the merge sort
    int count = 0;
    public int reversePairsOptimized(int[] nums) {
        int[] copy = new int[nums.length];
        mergeSort(nums, copy, 0, nums.length - 1);
        return count;
    }

    void mergeSort(int[] arr, int[] copy, int low, int high){
        if(low >= high){
            return;
        }

        // find the mid first
        int mid = (low + high) / 2;

        // now divide the first half
        mergeSort(arr, copy, low, mid);
        // divide the second half
        mergeSort(arr, copy, mid + 1, high);


        // we have to count the pairs before the merging
        countPairs(arr, low, mid, high);

        // now third step is merge the two halves
        merge(arr, copy, low, mid, high);
    }

    void countPairs(int[] arr, int start, int mid, int end){
        // run loop from start to mid only, for the first part only
        int right = mid + 1;
        for(int i = start; i <= mid; i++){

            // now move into the second part of the array, which is from mid + 1
            while(right <= end && arr[i] > 2L * arr[right]){
                right++;
            }

            // now add the distance travelled by the right
            count += right - (mid + 1);
        }
    }

    void merge(int[] arr, int[] temp, int start, int mid, int end){
        int left = start; // start of the first half
        int right = mid + 1; // start of the second half
        int i = start; // start of the temp

        while (left <= mid && right <= end){
            if(arr[left] <= arr[right]){
                temp[i] = arr[left];
                left++;
            }else {
                temp[i] = arr[right];
                right++;
            }
            i++;
        }

        // if at the end any of the half has some remaining elements then add those elements into the temp array
        while (left <= mid){
            temp[i] = arr[left];
            left++;
            i++;
        }

        while (right <= end){
            temp[i] = arr[right];
            right++;
            i++;
        }


        // now Add those elements into the original array
        for(i = start; i <= end; i++){
            arr[i] = temp[i];
        }
    }


    // brute force approach which will give TLE
    public int reversePairs(int[] nums) {
        // brute force
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                long required = 2L * nums[j];  // cast into long to prevent overflow, which leads to incorrect comparison
                if(nums[i] > required){
                    count++;
                }
            }
        }
        return count;
    }
}
