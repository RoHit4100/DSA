package Kunal.StackAndQueue;
public class CustomStack<T> {
    protected Object[] stack;
    protected int ptr = -1;
    private static final int DEFAULT_SIZE = 10;

    CustomStack(){
        this(DEFAULT_SIZE);
    }
    CustomStack(int size){
        stack = new Object[size];
    }

    public void add(T value){
        if(isFull()){
            return;
        }
        ptr++;
        stack[ptr] = value;
    }

    protected boolean isFull(){
        return ptr == stack.length;
    }
    public T remove() throws CustomStackException{
        if(isEmpty()){
            throw new CustomStackException("Cannot remove from empty stack");
        }

        return (T)stack[ptr--];
    }

    public boolean isEmpty(){
        return ptr == -1;
    }
    public T peek() throws  CustomStackException{
        if(isEmpty()){
            throw new CustomStackException("Cannot remove from empty stack");
        }

        return (T)stack[ptr];
    }
    public void display() throws CustomStackException{
        if(isEmpty()){
            throw new CustomStackException("Cannot remove from empty stack");
        }

        for(int i = 0; i <= ptr; i++){
            System.out.print(stack[i] + " ");
        }
        System.out.println("=> Top");
    }

}
