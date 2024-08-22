package Strivers.ArraysQuestions;

public class CountOfInversions {
    // optimal approach will use the mergeSort
    static int count = 0;
    static void mergeSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }

        // find the mid first
        int mid = (low + high) / 2;

        // now divide the first half
        mergeSort(arr, low, mid);
        // divide the second half
        mergeSort(arr, mid + 1, high);


        // now third step is merge the two halves
        merge(arr, low, mid, high);
    }

    static void merge(int[] arr, int start, int mid, int end){
        // get the temp array for storing the elements
        int[] temp = new int[start + end + 1];

        int left = start; // start of the first half
        int right = mid + 1; // start of the second half
        int i = 0; // start of the temp

        while (left <= mid && right <= end){
            if(arr[left] <= arr[right]){
                temp[i] = arr[left];
                left++;
            }else { // here we know that right is smaller than the left
                count += (mid - left + 1);
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
        for(int j = start; j <= end; j++){
            arr[j] = temp[j - start];
        }
    }

    static int countOfInversionUsingMS(int[] arr){
        mergeSort(arr, 0, arr.length - 1);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5,3,2,4,1};
        System.out.println(countOfInversions(arr));
        System.out.println(countOfInversionUsingMS(arr));
    }

    // brute force approach
    static int countOfInversions(int[] arr){
        // find the number of pairs in which first number is larger than second number
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }


    // solution for GFG
    static long inversionCount(long arr[], int n) {
        // Count the number of pairs:
        long[] temp = new long[n];
        return mergeAndCount(arr, temp, 0, n - 1);
    }

    public static long mergeAndCount(long[] arr, long[] temp, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        long inversions = 0;

        inversions += mergeAndCount(arr, temp, left, mid);        // Count inversions in left half
        inversions += mergeAndCount(arr, temp, mid + 1, right);   // Count inversions in right half

        inversions += mergeAndCountSplit(arr, temp, left, mid, right); // Count inversions during merge

        return inversions;
    }

    public static long mergeAndCountSplit(long[] arr, long[] temp, int left, int mid, int right) {
        int i = left;      // Starting index for left subarray
        int j = mid + 1;   // Starting index for right subarray
        int k = left;      // Starting index to be sorted
        long inversions = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversions += (mid + 1 - i);  // Count inversions
            }
        }

        // Copy the remaining elements of left subarray, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy the remaining elements of right subarray, if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the sorted subarray into Original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return inversions;
    }
}
