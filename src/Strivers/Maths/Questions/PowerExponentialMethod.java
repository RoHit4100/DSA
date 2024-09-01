package Strivers.Maths.Questions;

public class PowerExponentialMethod {
    // In this method we try to find the power of a number with given power
    // this has the time complexity of O(n)

    // first find the power with iteration
    private static int power(int b, int exp){
        if(exp == 1){
            return b;
        }

        long ans = 1;
        // run while loop till base becomes zero
        while(b > 0){
            if((exp & 1) == 1){ // means exponent is odd
                ans *= b;
            }
            exp >>= 1; // divide by two
            b = b * b; // take the square
        }
        return (int)ans;
    }


    // by recursive way
    static int findPower(int b, int exp, long result){
        if(b <= 0){
            return (int)result;
        }

        if((exp & 1) == 1){
            result *= b;
        }
        b *= b;
        exp >>= 1;
        return findPower(b, exp, result);
    }
    public static void main(String[] args) {
        System.out.println(power(2, 20));

        System.out.println(findPower(2, 20, 1));
    }
}
