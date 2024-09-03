package Strivers.Revision.ConversionRev;

import java.util.Stack;

class InfixToPostfix {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        if(exp.length() == 1){
            return exp;
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if(Character.isLetterOrDigit(ch)) {
                ans.append(ch);
            } else if(ch == '(') {
                stack.push(ch);
            } else if(ch == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    ans.append(stack.pop());
                }
                stack.pop(); // pop the '('
            } else { // operator encountered
                while(!stack.isEmpty() && priority(ch) <= priority(stack.peek())) { // if priority of current character is less than the top of the stack
                    ans.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop all remaining operators from the stack
        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.toString();
    }

    private static int priority(char operator) {
        if(operator == '^') {
            return 3;
        } else if(operator == '*' || operator == '/') {
            return 2;
        } else if(operator == '+' || operator == '-') {
            return 1;
        }
        return -1;
    }
}
