
class Factorial{
    public static void main(String[] args){
        int[] dp = new int[6];
        System.out.println(ansDP(5, dp));

        // lets try with tabulation
        int prev = 1;
        int ans = 0;
        for(int i = 2; i <= 5; i++){
            ans = prev * i;
            prev = ans;
        }
        System.out.print(ans);
    }

    static int ans(int n){
        if(n == 1){
            return n;
        }

        return n * ans(n - 1);
    }

    // this is the answer which uses DP for finding the factorial of a number.
    // this is example of memoization
    static int ansDP(int n, int[] dp){
        if(n == 1){
            return 1;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        return dp[n] = n * ansDP(n - 1, dp);
    }
}