package Kunal.LinkedList;

public class DoublyLL {

    private Node head;
    private int size;

    DoublyLL(){
        this.size = 0;
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        if(head != null){
            head.prev = node;
        }
        head = node;
        size++;
    }

    // we haven't taken the tail pointer so, I have to traverse till end to find the last node.
    public void insertLast(int value){
        if(head == null){
            insertFirst(value);
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        Node node = new Node(value, null, temp);
        temp.next = node;
        node.prev = temp;
        size++;
    }

    // insert after any index
    public void insertAfter(int value, int index){
        Node prevNode = head;
        for(int i = 0; i < index; i++){
            prevNode = prevNode.next;
        }
//        System.out.println(temp.value);
        Node node = new Node(value, prevNode.next, prevNode);
        if(prevNode.next != null){
            prevNode.next.prev = node;
        }
        prevNode.next = node;
    }

    public int remove(int value) throws Exception{
        Node node = get(value);
        int val = node.value;
        Node nextNode = node.next;
        if(nextNode != null){
            nextNode.prev = node.prev;
        }
        if(node.prev != null){
            node.prev.next = nextNode;
        }
        return val;
    }
    private Node get(int value) throws Exception{
        if(head == null){
            throw new Exception("List is empty");
        }
        Node temp = head;
        while (temp != null){
            if(temp.value == value){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public int find(int value){
        Node temp = head;
        int index = 0;
        while (temp != null){
            if(temp.value == value){
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("end");
    }

    public void displayReverse() throws  Exception{
        if(head == null) {
            throw new Exception("List is empty");
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        System.out.print("end -> ");
        while(temp.prev != null){
            System.out.print(temp.value + " -> ");
            temp = temp.prev;
        }
        System.out.println(temp.value);

    }
    private class Node{
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
        }

        Node(int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
