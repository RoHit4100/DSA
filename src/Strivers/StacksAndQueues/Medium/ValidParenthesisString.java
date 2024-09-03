package Strivers.StacksAndQueues.Medium;
import java.util.Stack;
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        // Stack to store indices of unmatched '(' characters
        Stack<Integer> open = new Stack<>();
        // Stack to store indices of '*' characters, which can be flexible
        Stack<Integer> stars = new Stack<>();

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // Push the index of '(' onto the open stack
                open.push(i);
            } else if (ch == '*') {
                // Push the index of '*' onto the stars stack
                stars.push(i);
            } else { // ch == ')'
                // Attempt to match ')' with a '(' from the open stack first
                if (!open.isEmpty()) {
                    open.pop();
                }
                // If no '(' is available, attempt to match with a '*' from the stars stack
                else if (!stars.isEmpty()) {
                    stars.pop();
                }
                // If neither is available, the string is invalid
                else {
                    return false;
                }
            }
        }

        // Attempt to match any remaining unmatched '(' with '*' by treating '*' as ')'
        while (!open.isEmpty() && !stars.isEmpty()) {
            // If an unmatched '(' is to the right of any '*', the string is invalid
            if (open.pop() > stars.pop()) {
                return false;
            }
        }

        // If any '(' remains unmatched, the string is invalid
        return open.isEmpty();
    }
}
