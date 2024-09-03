package Strivers.StacksAndQueues.Easy;

import java.util.Stack;

public class QueueUsingStack {
    // for this question I will need two stacks
    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        // there are two ways which you can solve this question, one is making it remove efficient and another is making insert efficient
        public void push(int x) {
            // first remove every single item from the stack1
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }

            // now insert the given element into stack1
            stack1.push(x);

            // now add adl
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }

        public int pop() {
            return stack1.pop();
        }

        public int peek() {
            return stack1.peek();
        }

        public boolean empty() {
            return stack1.isEmpty();
        }
    }

}
