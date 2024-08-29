package Strivers.Recursion.Questions.Medium;

public class StringToNum {
    public int myAToi(String s) {
        // Step 1: Trim leading and trailing spaces
        s = s.trim();

        // Step 2: Handle empty string case
        if (s.isEmpty()) {
            return 0;
        }

        // Step 3: Initialize variables
        int sign = 1;
        int index = 0;

        // Step 4: Handle optional leading '+' or '-'
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            index++;
        }

        // Step 5: Start the recursive helper function
        return helper(s, index, 0, sign);
    }

    private int helper(String s, int index, long result, int sign) {
        // Base case: If we've reached the end of the string or a non-digit character
        if (index >= s.length() || !Character.isDigit(s.charAt(index))) {
            return (int) result * sign;
        }

        // Add the current digit to the result
        result = result * 10 + (s.charAt(index) - '0');

        // Check for overflow and underflow
        if (sign == 1 && result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (sign == -1 && -result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        // Recursive call to process the next character
        return helper(s, index + 1, result, sign);
    }
}
