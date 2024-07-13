
class SumOfN{
    static int[] dp; 
    public static void main(String[] args) {
        dp = new int[6];
        System.out.println("Sum is " + sum(5));
    }  

    // this is using DP(memoization).
    static int sum(int n){
        if(n == 1){
            return 1;
        }

        if(dp[n] != 0)  return dp[n];
        return dp[n] = n + sum(n - 1);
    }
}