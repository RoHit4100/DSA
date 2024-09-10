package Strivers.GreedyAlgorithms.Medium;

import java.util.Stack;

public class ValidParenthesis {
    // optimal solution using the range of 0-1
    public boolean checkValidStringOptimal(String s) {
        // 'min' represents the minimum possible number of open parentheses required.
        // 'max' represents the maximum possible number of open parentheses we can have.
        int min = 0, max = 0;

        // Traverse each character in the string
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                // If we encounter '(', both min and max increase because
                // it adds to the number of open parentheses.
                min++;
                max++;
            } else if(ch == ')'){
                // If we encounter ')', both min and max decrease because
                // it closes an open parenthesis.
                min--;
                max--;
            } else { // for '*' character
                // For '*', max increases as it could be treated as an opening parenthesis.
                // min decreases as it could be treated as a closing parenthesis.
                max++;
                min--;
            }

            // If min goes below 0, reset it to 0 because we can't have fewer than 0 open parentheses.
            // This ensures that the closing parentheses are not more than the opening ones.
            if(min < 0){
                min = 0;
            }

            // If max goes below 0, it means there are too many closing parentheses,
            // so it's impossible to balance the string.
            if(max < 0)
                return false;
        }

        // After processing all characters, the string is valid if we have zero open parentheses left.
        return min == 0;
    }

    // better solution using two stacks
    public boolean checkValidStringBetter(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> stars = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open.push(i);
            } else if (ch == '*') {
                stars.push(i);
            } else { // ch == ')'
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!stars.isEmpty()) {
                    stars.pop();
                } else {
                    return false;
                }
            }
        }

        // Now try to match remaining '(' with remaining '*'
        while (!open.isEmpty() && !stars.isEmpty()) {
            if (open.pop() > stars.pop()) {
                return false;
            }
        }

        return open.isEmpty();
    }

    // brute force solution using recursion, as we have to check all the paths
    public boolean checkValidString(String s) {
        // this will be the brute force solution using recursion
        return helper(s, 0, 0);
    }

    private boolean helper(String s, int index, int count){
        if(count < 0) return false; // return false, if any point of time count becomes negative
        if(index == s.length()){
            return count == 0; // if we are at the end of the string, then check if the count is zero or not
        }

        // now check the current char
        // if char is '(' then increment the count
        // if ')' decrement the count
        // if '*' then try out all the possible conditions

        if(s.charAt(index) == '(') return helper(s, index + 1, count + 1); // try path for opening parenthesis
        else if(s.charAt(index) == ')') return helper(s, index + 1, count - 1); // try path for closing parenthesis

        // try paths for *
        return helper(s, index + 1, count) || helper(s, index + 1, count + 1) || helper(s, index + 1, count - 1);
    }
}
