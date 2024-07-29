package Kunal.StackAndQueue.Questions;

import java.util.Stack;

public class CreateQueueWithStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();


    // we can create a queue using two stacks but while doing this we have to compromise over any one of operation,
    // between push and pop
    // if we want to create insertion efficient queue then we have to compromise over complexity of the deletion

    void push(int x){
        stack1.push(x);
    }

    int pop(){
        // now to remove item from bottom of the stack but, stack doesn't allow this, so first we have to
        // transfer all the items into the second stack and then remove the element present at the top of the stack.
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        // in the end stack1 will be empty, and then we can remove the top most element
        int removed = (int) stack2.pop();
        // now we have to fill the stack1 again
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return removed;
    }


    public int peek() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        // in the end stack1 will be empty, and then we have to peek the first element present in the stack2,
        int firstElement = (int)stack2.peek();
        // now we have to fill the stack1 again
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return firstElement;
    }



    // above method was insertion efficient, now lets make deletion efficient

    public void pushN(int x){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        // now the first stack is empty, now I have to push element in the stack 1, that will make sure that the last element
        // to be inserted is at the bottom of the stack
        stack1.push(x);
        // after inserting we have to push all the elements from stack2 to stack1.
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int popN(){
        return stack1.pop();
    }

    public int peekN(){
        return stack1.peek();
    }
}
