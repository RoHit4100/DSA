package Strivers.LinkList;

public class SinglyLL {
    Node head;
    int size;

    SinglyLL(){
        this.size = 0;
        this.head = null;
    }

    // insert first
    void insertFirst(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            size++;
            return;
        }
        node.next = head;
        head = node;
        size++;
    }

    void insertLast(int val){
        if(head == null){
            insertFirst(val);
            return;
        }

        // first find the end of the LL
        Node node = new Node(val);
        Node last = get(size);
        last.next = node;
        size++;
    }


    private Node get(int index){
        if(head == null){
            return null;
        }

        Node node = head;
        int i = 0;
        while (node.next != null && i != index){
            node = node.next;
            i++;
        }
        // now send the current node
        return node;
    }

    int removeFirst() throws Exception{
        if(head == null){
            throw new Exception("Cannot remove element from the empty list");
        }
        int removed = head.val;
        head = head.next;
        size--;
        return removed;
    }

    int removeLast() throws Exception{
        if(head == null){
            throw new Exception("Cannot remove element from the empty list");
        }


        Node secondLast = get(size - 2);
        int removed = secondLast.next.val;
        secondLast.next = null;
        return removed;
    }

    int remove(int index) throws Exception{
        if(index > size){
            throw new Exception("index is greater than the size of the list");
        }
        if(head == null){
            throw new Exception("Cannot remove from the empty list");
        }
        if(index == 0){
            return removeFirst();
        }
        if(index == size){
            return removeLast();
        }
        Node node = get(index);
        int removed = node.val;
        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
        return removed;
    }


    // display
    void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }


    void reverse() {
        if (head == null) {
            return;
        }

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    private class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
}
