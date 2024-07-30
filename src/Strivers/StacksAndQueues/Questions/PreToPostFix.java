package Strivers.StacksAndQueues.Questions;

import java.util.Stack;

public class PreToPostFix {
    public static void main(String[] args) {

    }

    public static String convert(Stack<String> stack, String eq){
        // here I only have to maintain the stack.
        int i = 0;
        while (i < eq.length()){
            char ch = eq.charAt(i);
            // I have to check whether current character is operand or operator
            if(Character.isLetterOrDigit(ch)){
                stack.push(ch + "");
            }else{
                String top1 = stack.pop();
                String top2 = stack.pop();
                String conversion = "(" + top2 + ch + top1 +")";
                stack.push(conversion);
            }
            i++;
        }
        return stack.peek();
    }
}
