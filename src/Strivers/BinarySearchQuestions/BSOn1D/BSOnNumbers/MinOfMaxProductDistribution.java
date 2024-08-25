package Strivers.BinarySearchQuestions.BSOn1D.BSOnNumbers;

public class MinOfMaxProductDistribution {
    // using binary search for optimization
    public int minimizedMaximumOptimal(int n, int[] quantities){
        int max = Integer.MIN_VALUE;
        for(int i: quantities){
            max = Math.max(i, max);
        }

        int start = 1;
        int end = max;
        while (start <= end){
            int mid = start + (end - start) / 2;

            if(check(quantities, n, mid)){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    // brute force approach
    public int minimizedMaximum(int n, int[] quantities) {
        int max = Integer.MIN_VALUE;
        for(int i: quantities){
            max = Math.max(i, max);
        }

        for(int i = 1; i <= max; i++){
            boolean possible = check(quantities, n, i);
            if(possible){
                return i;
            }
        }
        return max;
    }

    boolean check(int[] quantities, int n, int q){
        int total = 0;
        for (int quantity : quantities) {
            total += (quantity + q - 1) / q; // Integer math to simulate Math.ceil(quantity / q)
            if (total > n) {
                return false;
            }
        }
        return true;
    }
}
