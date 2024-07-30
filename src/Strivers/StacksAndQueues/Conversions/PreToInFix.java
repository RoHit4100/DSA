package Strivers.StacksAndQueues.Conversions;

import java.util.Stack;

public class PreToInFix {
    public static void main(String[] args) {
        System.out.println(convert(new Stack<String>(), "+a*bc"));
    }

    static String convert(Stack<String> stack, String eq){
        // to convert prefix into the infix we have to start from the end of the string
        int i = eq.length() - 1;
        while (i >= 0){
            char ch = eq.charAt(i);
            // first we have to check whether the current character is operand or not
            if(Character.isLetterOrDigit(ch)){
                stack.push(ch + "");
            }else{
                // now pop the first two element of the stack
                String top1 = stack.pop();
                String top2 = stack.pop(), conversion;
                conversion = "(" + top1 + ch + top2 + ")";
                stack.push(conversion);
            }
            i--;
        }
        return stack.peek();
    }
}