package Strivers.StacksAndQueues.ConversionRev;
import java.util.Stack;
public class PostToPre {
    static String postToPre(String s){
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(ch +"");
            }else{
                String first = stack.pop();
                String second = stack.pop();

                String conversion = ch + second + first;
                stack.push(conversion);
            }
        }

        return stack.peek();
    }
}
