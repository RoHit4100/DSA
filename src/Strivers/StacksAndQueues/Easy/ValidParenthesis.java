package Strivers.StacksAndQueues.Easy;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        // in this problem we have to check for each opening parenthesis is there any closing parenthesis
        if(s.length() == 1){
            return false;
        }

        // we wil use the stack to solve this problem
        Stack<Character> stack = new Stack<>(); // this stack will only store the opening parenthesis

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){ // only opening parenthesis are added into the stack
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false; // check if stack is empty, when we first time encountered the closing parenthesis
                    // if yes then return false immediately
                }
                char top = stack.pop(); // get the top element of the stack
                // now compare the current character with the stack top
                if((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')){
                    return false;
                }
            }
        }
        return stack.isEmpty(); // return if stack is empty or not, if every bracket has the closing bracket then stack will be empty
    }
}
