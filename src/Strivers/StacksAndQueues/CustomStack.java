package Strivers.StacksAndQueues;

public class CustomStack {
    private int[] stack = new int[100];
    private int size;
    CustomStack(){
        this.size = -1;
    }

    public void push(int val) throws Exception{
        if(isFull()){
            throw new Exception("Stack is Full");
        }

        size++;
        stack[size] = val;
    }

    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot pop from empty stack");
        }

        int popped = stack[size];
        size--;
        return popped;
    }

    public int peek() throws Exception{
        if(isEmpty() || isFull()){
            throw new Exception("perform valid operation");
        }

        return stack[size];
    }
    public void display(){
        for(int i = 0; i <= size; i++){
            System.out.print(stack[i] + ", ");
        }
        System.out.println();
    }
    public int size(){
        return size;
    }
    private boolean isFull(){
        return size == stack.length - 1;
    }
    private boolean isEmpty(){
        return size == -1;
    }


    public static void main(String[] args) throws Exception {
        CustomStack stack = new CustomStack();
        for(int i = 1; i <= 10; i++){
            stack.push(i);
        }
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.display();
    }
}
