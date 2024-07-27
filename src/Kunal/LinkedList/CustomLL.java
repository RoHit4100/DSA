package Kunal.LinkedList;

import java.util.Currency;

public class CustomLL {
    private Node head;
    private Node tail;
    private int size;
    CustomLL(){
        this.size = 0;
    }

    // never move head location until and unless u wanted to change the whole structure of the LL, if u want to traverse
    // then just use the temp node.
    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void insertLast(int value){
        if(tail == null){
            insertFirst(value);
        }
        // by using tail reference variable or pointer
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int value, int index){
        if(index == 0){
            insertFirst(value);
            return;
        }
        if(index == size){
            insertLast(value);
            return;
        }

        Node temp = head;
        // not starting from the zero as zero is the head itself.
        int i = 1;
        while (i < index){
            temp = temp.next;
            i++;
        }
        // creating the new node while assigning the next value of that node to next node of target index's previous node.
        Node node = new Node(value, temp.next);
        // now connecting previous node to the newly created node
        temp.next = node;
/*
        or
        node.next = temp.next;
        temp.next = node;
*/

        size++;
    }
    public void display(){
        Node temp = head;
        Node last;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void add(int value){

    }
    private class Node{
        private int value;
        private Node next;

        Node(int value){
            this.value = value;
        }

        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
