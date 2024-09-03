package Strivers.Revision.ConversionRev;

import java.util.Stack;

public class InfixToPrefix {
    static String preToInfix(String s) {
        // In this solution we will follow some steps, first we have to reverse the given string


        // NOTE: while reversing, you to convert all the '(' to ')', and vise versa
        // after that find the infix to postfix and then reverse the answer

        // step1: reverse
        StringBuilder reversed = new StringBuilder(s);
        reversed.reverse();
        // now convert '(' to ')' and vise versa
        for(int i = 0; i < reversed.length(); i++){
            char ch = reversed.charAt(i);
            if(ch == '('){
                reversed.setCharAt(i, ')');
            }else if(ch == ')'){
                reversed.setCharAt(i, '(');
            }
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        // now we have updated string on which we can perform in to post conversion
        for(int i = 0; i < reversed.length(); i++){
            char ch = reversed.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                ans.append(ch);
            }else if(ch == '('){
                stack.push(ch);
            }else if(ch == ')'){
                // now pop the characters from the stack until you encounter opening braces
                while (!stack.isEmpty() && stack.peek() == '('){
                    ans.append(stack.pop());
                }
                // if stack is not empty then pop the opening bracket
                if(!stack.isEmpty()){
                    stack.pop(); // pop the opening bracket
                }
            }else{ // if any of the above case is not true means, this character is an operator
                // now pop the item out of the stack until you find any of the element which have the lesser or equal priority than the
                // current character
                if(ch == '^'){
                    while (!stack.isEmpty() && priority(ch) <= priority(stack.peek())){ // this loop will ensure that u cannot
                        // store two powers in the stack at the same time
                        ans.append(stack.pop());
                    }
                }else {
                    while (!stack.isEmpty() && priority(ch) < priority(stack.peek())){ // in this the operator strictly has to lower priority
                        ans.append(stack.pop());
                    }
                }
                stack.push(ch); // in the end push the current operator into the stack
            }
        }

        // now check if stack has any operator left
        while (!stack.isEmpty()){
            ans.append(stack.pop()); // add all the left out operators to the answer
        }

        return ans.toString();
    }

    private static int priority(char ch){
        if(ch == '^'){
            return 3;
        }else if(ch == '*' || ch == '/'){
            return 2;
        }else if(ch == '+' || ch == '-'){
            return 1;
        }

        return -1;
    }
    public static void main(String[] args) {
        preToInfix("*-A/BC-/AKL");
    }
}
