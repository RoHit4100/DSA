package Kunal.StackAndQueue;

public class CircularQueue {
    private int[] queue;
    private int end = 0;
    private int front = 0;
    private int size = 0;
    private static final int DEFAULT_SIZE = 10;

    CircularQueue(){
        this(DEFAULT_SIZE);
    }

    CircularQueue(int size){
        queue = new int[size];
    }

    private boolean isFull(){
        return size == queue.length;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    public void add(int value) throws Exception{
        if(isFull()){
            throw new Exception("Queue is full");
        }
        queue[end++] = value;
        end = end % queue.length;
        size++;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot remove from empty queue");
        }

        int removed = queue[front++];
        front = front % queue.length;
        size--;
        return removed;
    }

    public void display() throws CustomStackException{
        if(isEmpty()){
            throw new CustomStackException("Cannot remove from empty queue");
        }
        int i = front;
        do{
            System.out.print(queue[i] + " <- ");
            i++;
        }while (i != end);
        System.out.println("Last");
    }
}
