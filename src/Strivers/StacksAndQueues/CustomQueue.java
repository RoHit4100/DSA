package Strivers.StacksAndQueues;

public class CustomQueue <T> {
    private Object[] queue = new Object[10];
    private int size;
    private int start = -1;
    private int end = -1;
    CustomQueue(){
        this.size = -1;
    }

    public void push(T val) throws Exception{
        if(start == -1){
            end++;
            start++;
            queue[start] = val;
            size++;
            return;
        }
        end++;
        end = end % queue.length;
        queue[end] = val;
        size++;
    }

    public T pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot pop from empty stack");
        }

        if(size == 1){
            T p = (T)queue[start];
            start = -1;
            end = -1;
            return p;
        }
        T popped =  (T) queue[start];
        start++;
        start = (start) % queue.length;
        size--;
        return popped;
    }

    public T peek() throws Exception{
        if(isEmpty() || isFull()){
            throw new Exception("perform valid operation");
        }

        return (T) queue[start];
    }
    public int size(){
        return size + 1;
    }
    private boolean isFull(){
        return size == queue.length - 1;
    }
    private boolean isEmpty(){
        return size == -1;
    }


    public static void main(String[] args) throws Exception {
        CustomQueue<Integer> queue = new CustomQueue<>();
        for(int i = 1; i <= 10; i++){
            queue.push(i);
        }
        for(int i = 0; i < 10; i++){
            System.out.println(queue.pop());
        }
        System.out.println(queue.size());
    }
}
