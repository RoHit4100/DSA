package Strivers.StacksAndQueues.Medium;

import java.util.Stack;

public class MinStackQuestion {
    // brute force solution will be using pair data structure to the min of the stack
    class MinStack1 {
        // define the pair, which will store the min and the current element of the stack
        class Pair{
            int element;
            int min;
            Pair(int element, int min){
                this.element = element;
                this.min = min;
            }
        }
        Stack<Pair> stack;
        public MinStack1() {
            stack = new Stack<>();
        }

        public void push(int val) {
            // initially min will be the same as the first element if stack is empty
            int min = val;
            if(!stack.isEmpty()){ // if stack is not empty then the actual logic comes
                min = stack.peek().min; // get the current min of the stack, from the top
                if(val < min){ // check the current val, is smaller than the min of the stack
                    min = val; // if min then that will the min
                }
            }
            // create new pair with min and the current val
            Pair pair = new Pair(val, min);
            // now insert the pair into the stack
            stack.push(pair);
        }

        public void pop() {
            // pop the pair
            stack.pop();
        }

        public int top() {
            // get the top element of the pair
            return stack.peek().element;
        }

        public int getMin() {
            // get the min of the pair
            return stack.peek().min;
        }
    }


}
