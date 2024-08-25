package Strivers.BinarySearchQuestions.BSOn1D.BSOnNumbers;

public class KthMissingPositive {
    // optimal solution will use the BS
    public int findKthPositiveOptimal(int[] arr, int k) {
        int start = 0; // this will be the start of the array
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            int missing = arr[mid] - (mid + 1);
            if(missing < k){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return start + k; // or end + k + 1;
    }

    // brute force approach
    public int findKthPositive(int[] arr, int k) {
        // in this approach we will just check whether the current num is greater than or equal to the k
        // if not then just break and return k itself;
        for(int num: arr){
            if(k >= num){
                k++;
            }else{
                break;
            }
        }
        return k;
    }
}
