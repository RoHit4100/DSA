package Strivers.StacksAndQueues;

public class QueueUsingLL extends StacksUsingLL {
    Node start;
    Node end;
    QueueUsingLL(){
        super();
    }

    @Override
    public void push(int value) {
        Node node = new Node(value);
        if(start == null){
            start = node;
            end = node;
            return;
        }

        end.next = node;
        end = node;
        super.size++;
    }

    @Override
    public int pop() throws Exception {
        if(size == 0){
            throw new Exception("Cannot perform pop on empty stack");
        }
        int removed = end.value;
        start = start.next;
        if(start == null){
            end = null;
        }
        size--;
        return removed;
    }
}
