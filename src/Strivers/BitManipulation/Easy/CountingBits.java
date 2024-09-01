package Strivers.BitManipulation.Easy;

public class CountingBits {
    // brute force approach
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for(int i = 1; i < ans.length; i++){
            ans[i] = getTheCount(i);
        }
        return ans;
    }

    private int count(int n){
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
    private int getTheCount(int n){
        int count = 0;
        while(n != 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }


    // coding ninja
    private static long MOD = 1000000007;
    public static int countSetBits(int n){
        //    Write your code here.
        int count = 0;
        for(int i = 1; i <= n; i++){
            count += getCount(i);
        }
        return (int)(count % MOD);
    }

    private static int getCount(int n){
        long count = 0;
        while (n != 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }

        return (int) (count % MOD);
    }
}
