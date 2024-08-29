package Strivers.Recursion.Questions.Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseStack {
    // this solution uses queue to reverse the stack
    static void reverse(Stack<Integer> s){
        // add your code here
        // in this solution I wll take queue
        Queue<Integer> queue = new LinkedList<>();
        helper(s, queue);
    }

    private static void helper(Stack<Integer> stack, Queue<Integer> queue){
        if(stack.isEmpty()){
            return;
        }

        // pop from stack and push into queue
        int popped = stack.pop();
        // push into queue
        queue.offer(popped);
        helper(stack, queue);  // pass to empty stack
        stack.push(queue.poll());
    }


    // now solution without using queue
    static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }

        // first empty the stack
        int popped = stack.pop();
        reverseStack(stack); // this function will help to empty the stack
        // now call insert function which will insert the last popped element into the stack
        insert(stack, popped);
    }

    private static void insert(Stack<Integer> stack, int element){
        if (stack.isEmpty()){
            stack.push(element); // this will push the given element
            return;
        }

        // first popped all the elements from the stack
        int popped = stack.pop();
        insert(stack, element); // this will make sure that all the elements are popped
        stack.push(popped);
    }
}
