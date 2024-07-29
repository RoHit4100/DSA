package Kunal.StackAndQueue;

public class CustomQueue {
    private int[] queue;
    private int end = 0;
    private static final int DEFAULT_SIZE = 10;

    CustomQueue(){
        this(DEFAULT_SIZE);
    }

    CustomQueue(int size){
        queue = new int[size];
    }

    private boolean isFull(){
        return end == queue.length;
    }

    private boolean isEmpty(){
        return end == 0;
    }

    public void add(int value) throws Exception{
        if(isFull()){
            throw new Exception("Queue is full");
        }

        queue[end++] = value;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot remove from empty queue");
        }

        // removal in queue take O(n) complexity, as we have to remove first element and swap each element to its previous location
        int removed = queue[0];
        // now I have to swap each element to its previous element.
        for(int i = 1; i < end; i++){
            queue[i - 1] = queue[i];
        }
        end--;
        return removed;
    }

    public void display() throws CustomStackException{
        if(isEmpty()){
            throw new CustomStackException("Cannot remove from empty queue");
        }
        for(int i = 0; i < end; i++){
            System.out.print(queue[i] + " <- ");
        }
        System.out.println(" Last");
    }
}
