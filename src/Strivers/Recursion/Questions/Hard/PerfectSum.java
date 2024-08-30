package Strivers.Recursion.Questions.Hard;


public class PerfectSum {
    private final long MOD = 1000000007;
    public int perfectSum(int[] arr,int n, int sum){
        // Your code goes here
        long count = getCount(arr, 0, 0, sum) % MOD;
        return (int) count;
    }

    private long getCount(int[] arr, int index, int sum, int k){
        if(index >= arr.length){
            if (sum == k){
                return 1;
            }
            return 0;
        }

        // take it
        sum += arr[index];
        long left = getCount(arr, index + 1, sum, k);

        // not take it
        sum -= arr[index];
        long right = getCount(arr, index + 1, sum, k);
        return (left + right) % MOD;
    }
}
