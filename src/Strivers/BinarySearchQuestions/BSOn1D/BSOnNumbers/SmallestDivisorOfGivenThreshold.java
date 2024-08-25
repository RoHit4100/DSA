package Strivers.BinarySearchQuestions.BSOn1D.BSOnNumbers;

public class SmallestDivisorOfGivenThreshold {
    // optimal approach will be using BS
    public int smallestDivisorOptimal(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(max, num);
        }

        // start BS
        int start = 1;
        int end = max;

        while (start <= end){
            int mid = start + (end - start) / 2;

            boolean possible = check(nums, threshold, mid);
            if(possible){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    // brute force approach
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(max, num);
        }

        for(int i = 1; i <= max; i++){
            boolean possible = check(nums, threshold, i);
            if(possible){
                return i;
            }
        }
        return -1;
    }

    boolean check(int[] arr, int threeshold, int x){
        int totalSum = 0;

        for(int num: arr){
            totalSum += (int)Math.ceil((double)num/ (double)x);
        }
        return totalSum <= threeshold;
    }
}
