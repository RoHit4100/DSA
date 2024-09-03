package Strivers.Revision.ConversionRev;

import java.util.Stack;

public class PostToInfix {
    public static String postToInfix(String exp) {
        // to convert infix to post fix we have to find a different approach
        Stack<String> stack = new Stack<>();
        // here I have to insert operands into the stack, and whenever you find the operator just put it in between last two elements
        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(ch+"");
            }else { // this means the current element is operator
                // get the last two strings
                String first = stack.pop();
                String second = stack.pop();

                String infix = "(" + second + ch + first + ")";
                stack.push(infix);
            }
        }
        return stack.peek();
    }

}
