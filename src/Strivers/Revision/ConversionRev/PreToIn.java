package Strivers.Revision.ConversionRev;

import java.util.Stack;

public class PreToIn {
    static String preToInfix(String s) {
        // here we will start our iteration from the end of the string
        Stack<String> stack = new Stack<>();
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);

            // first check if the current character is operand or not
            if(Character.isLetterOrDigit(ch)){
                stack.push(ch+"");
            }else{ // means we have found the operator
                String first = stack.pop();
                String second = stack.pop();

                String str = "(" + first + ch + second + ")";
                stack.push(str);
            }
        }

        return stack.peek();
    }
}
