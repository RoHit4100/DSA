package Kunal.LinkedList;

public class CircularLL {
    private Node head;
    private Node tail;
    private int size;
    CircularLL(){
        this.size = 0;
    }

    public void insert(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
            tail = node;
        }

        node.next = head;
        tail.next = node;
        tail = node;
    }

    public void delete(int value){
        Node temp = head;

        if(head != null) {
            if(temp.value == value){
                head = temp.next;
                tail = head;
                return;
            }
            do {
                if (temp.next.value == value) {
                    if (temp.next.next == tail) {
                        tail = temp;
                    }
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            } while (temp != head);
        }
    }

    public void display(){
        Node temp = head;
//        while(temp != tail){
//            System.out.print(temp.value + " -> ");
//            temp = temp.next;
//        }
//        System.out.println(temp.value + " -> Head");

        // or
        if(head != null){
            do{
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }while(temp != head);
            System.out.println("Head");
        }

    }


    private class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
