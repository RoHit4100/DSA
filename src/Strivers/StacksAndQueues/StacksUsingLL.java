package Strivers.StacksAndQueues;

public class StacksUsingLL {
    Node top;
    int size;
    StacksUsingLL(){
        this.size = 0;
    }


    public void push(int value){
        Node node = new Node(value);
        if(top == null) {
            top = node;
            size++;
            return;
        }
        node.next = top;
        top = node;
        size++;
    }

    public int pop() throws Exception{
        if(size == 0){
            throw new Exception("Cannot perform pop on empty stack");
        }
        int removed = top.value;
        top = top.next;
        size--;
        return removed;
    }

    protected class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }
}
