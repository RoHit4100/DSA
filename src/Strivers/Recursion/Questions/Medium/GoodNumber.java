package Strivers.Recursion.Questions.Medium;

public class GoodNumber {
    private static final long MOD = 1000000007;
    // this will be the iterative solution.
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        long first = power(5, even, 1);
        long second = power(4, odd, 1);

        return (int)((first * second) % MOD);
    }

    private long power1(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) != 0) { // If exp is odd
                result = (result * base) % mod;
            }
            base = (base * base) % mod; // Square the base
            exp >>= 1; // Divide exp by 2
        }
        return result;
    }

    // now power method using recursion
    private long power(long base, long exp, long result){
        if(exp <= 0){
            return result;
        }

        if((exp & 1) == 1){ // odd case
            result = (result * base) % MOD;
        }
        exp /= 2;
        base = (base * base) % MOD;

        return power(base, exp, result);
    }
}
