package Strivers.Recursion.Questions.Medium;

import java.util.Collections;
import java.util.Stack;

public class SortStack {
    // this is using collections framework
    public Stack<Integer> sort2(Stack<Integer> s) {
        // add code here.
        Collections.sort(s);
        return s;
    }

    public Stack<Integer> sort(Stack<Integer> stack){
        if(stack.isEmpty()){
            return stack;
        }

        helper(stack);
        return stack;
    }

    private static void helper(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }

        int popped = stack.pop();
        helper(stack);
        insert(stack, popped);
    }

    static void insert(Stack<Integer> stack, int element){
        if(stack.isEmpty()){
            stack.push(element);
            return;
        }

        int top = stack.peek();
        if(element < top){
            stack.pop();
        }else {
            stack.push(element);
            return;
        }
        insert(stack, element);
        stack.push(top);
    }
}
