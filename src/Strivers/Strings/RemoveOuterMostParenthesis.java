package Strivers.Strings;

import java.util.Stack;

public class RemoveOuterMostParenthesis {
    // optimal solution
    public String removeOuterParenthesesOptimal(String s) {
        if(s.length() == 1) return "";

        // initialize the count
        int count = 0;
        // this will store the answer
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(count > 0){ // add into answer only if count is greater than 0
                    ans.append(ch);
                }
                count++; // increase the count for each opening parenthesis
            }else{
                count--; // decrement the count for each closing parenthesis
                if(count > 0){ // add only into answer if count is greater than 0
                    ans.append(ch);
                }
            }
        }
        // return the answer
        return ans.toString();
    }

    // brute force solution
    public String removeOuterParentheses(String s) {
        // if stack is empty then add only into stack or, else add into answer
        // if closing bracket is encounter pop the top most, and check if stack is emptied or not, if not then
        // add that bracket into answer

        // return empty string if string has only 1 item
        if(s.length() == 1) return "";
        // this will store the answer
        StringBuilder ans = new StringBuilder();
        // this help to keep track of the brackets
        Stack<Character> stack = new Stack<>();
        // traverse for each bracket
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i); // get the current char
            if(ch == '('){ // check if opening parenthesis
                if(!stack.isEmpty()){ // add it to answer only, if stack is not empty
                    ans.append("(");
                }
                stack.push('('); // push that into answer
            }else{
                // check if stack is empty or not
                if(stack.isEmpty()){ // if stack is already empty then return the empty string
                    return "";
                }else{ // if not then pop from the stack and check if, stack is empty or not
                    stack.pop();
                    // check if the stack has become empty or not
                    if(!stack.isEmpty()){ // if not then add the closing parenthesis into answer
                        ans.append(")");
                    }
                }
            }
        }
        // return the answer
        return ans.toString();
    }
}
