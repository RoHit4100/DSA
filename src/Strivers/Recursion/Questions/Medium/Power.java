package Strivers.Recursion.Questions.Medium;

public class Power {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1; // Anything raised to the power of 0 is 1
        }

        // Handle the case of negative powers
        long absN = Math.abs((long)n);
        double result = 1.0;

        while (absN > 0) {
            if (absN % 2 == 1) { // Odd case
                result *= x;
            }
            x *= x; // Square the base
            absN /= 2; // Divide the power by 2
        }

        // If the original power was negative, invert the result
        return (n < 0) ? 1 / result : result;
    }


    // now solve this question using recursion
    public double pow(double x, int n){
        if(n == 0){
            return 1;
        }
        long absN = Math.abs((long)n);
        double result = helper(x, absN, 1);

        if (n < 0){
            return 1 / result;
        }
        return result;
    }

    public double helper(double x, long n, double result){
        if(n <= 0){
            return result;
        }

        if(n % 2 != 0){ // odd case
            result = result * x;
        }
        x *= x; // take the square of x
        n /= 2; // reduce the power by 2
        return helper(x, n, result); // calling recursively
    }


}
