package Strivers.StacksAndQueues.Medium;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0"; // If k equals the length of num, we remove all digits, so return "0"
        }

        // We will use a stack (as a StringBuilder) to store the final digits
        StringBuilder stack = new StringBuilder();

        // Traverse through the num
        for (int i = 0; i < num.length(); i++) {
            // Remove digits from the stack while the current digit is smaller than the previous one
            // and we still need to remove digits (k > 0)
            while (k > 0 && !stack.isEmpty() && stack.charAt(stack.length() - 1) > num.charAt(i)) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            // Push the current digit onto the stack
            stack.append(num.charAt(i));
        }

        // If there are still digits to remove (k > 0), remove them from the end
        while (k > 0 && !stack.isEmpty()) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Remove leading zeros
        int j = 0;
        while (j < stack.length() && stack.charAt(j) == '0') {
            j++;
        }

        // If the result is empty after removing zeros, return "0"
        if (j == stack.length()) {
            return "0";
        }

        // Return the final result after removing leading zeros
        return stack.substring(j);
    }
}
