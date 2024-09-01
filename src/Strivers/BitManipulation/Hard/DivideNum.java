package Strivers.BitManipulation.Hard;

public class DivideNum {
    public int divide(int dividend, int divisor) {
        long c = 0; // 'c' will store the quotient (the result of the division).
        long sign = 1; // 'sign' will store the sign of the final result.

        // If divisor is 1, return the dividend as it is since any number divided by 1 is itself.
        if (divisor == 1) return dividend;

        // Determine the sign of the result.
        // If one of the dividend or divisor is negative, the result should be negative.
        if ((dividend < 0 && divisor >= 0) || (dividend >= 0 && divisor < 0)) {
            sign = -1;
        }

        // Convert both dividend and divisor to their absolute values to simplify division logic.
        long dd = Math.abs((long) dividend); // 'dd' is the absolute value of the dividend.
        long dr = Math.abs((long) divisor); // 'dr' is the absolute value of the divisor.

        // Perform division using bitwise shifts and subtraction.
        // The loop checks if the dividend is greater than or equal to the divisor shifted by 'i' bits.
        // If true, subtract the shifted divisor from the dividend and add the corresponding power of 2 to 'c'.
        for (int i = 30; i >= 0; i--) {
            // Check if 'dd' is greater than or equal to 'dr' shifted left by 'i' positions.
            if (dd >= (dr << i)) {
                c += (1L << i); // Add the value 2^i to 'c' as this contributes to the quotient.
                dd -= (dr << i); // Subtract 'dr << i' from 'dd' to continue the division.
            }
        }

        // Multiply the quotient by the sign to get the final result and cast it back to 'int'.
        return (int) (c * sign);
    }
}
