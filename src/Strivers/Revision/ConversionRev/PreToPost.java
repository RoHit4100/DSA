package Strivers.Revision.ConversionRev;

import java.util.Stack;

public class PreToPost {
    static String preToPost(String s) {
        // code here
        Stack<String> stack = new Stack<>();
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                stack.push(ch+"");
            }else{
                String first = stack.pop();
                String second = stack.pop();

                String conversion = first + second + ch;
                stack.push(conversion);
            }
        }

        return stack.peek();
    }
}
