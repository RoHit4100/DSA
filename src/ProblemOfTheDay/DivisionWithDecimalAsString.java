package ProblemOfTheDay;

public class DivisionWithDecimalAsString {
    public static String divisionWithDecimal(int x, int y, int n){
        StringBuilder ans = new StringBuilder();
        boolean isNegative = x < 0 || y < 0;
        boolean bothNegative = x < 0 && y < 0;
        // now first find the quotient and the find the remainder
        x = Math.abs(x);
        y = Math.abs(y);
        int quotient = x / y;
        int remainder = x % y;

        // now this will store the value as a string, // e.g. 1.
        ans.append(quotient).append(".");

        // now find the rest decimal digits
        for(int i = 0; i < n; i++){
            remainder *= 10;

            int digit = remainder / y;
            ans.append(digit);
            remainder %= y;
        }
        if(isNegative & !bothNegative){
            ans.insert(0, "-");
        }
        return ans.toString();
    }
}
