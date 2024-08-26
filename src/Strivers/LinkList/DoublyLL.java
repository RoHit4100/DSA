package Strivers.LinkList;

public class DoublyLL {
    Node head;
    int size;
    DoublyLL(){
        this.size = 0;
    }

    void insertFirst(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            size++;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }

    void insertLast(int val){
        if(head == null){
            insertFirst(val);
            return;
        }

        // first find the end of the LL
        Node last = get(size - 1);
        Node node = new Node(val);
        node.prev = last;
        last.next = node;
        size++;
    }

    void insert(int index, int val) throws Exception{
        if(index >= size && index < 0){
            throw new Exception("Index out of bound");
        }
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size - 1){
            insertLast(val);
            return;
        }

        // now insert at that particular index
        // for that first get the index
        Node targetNode = get(index);
        Node temp = targetNode.next;
        Node node = new Node(val);
        temp.prev = node;
        targetNode.next = node;
        node.next = temp;
        node.prev = targetNode;
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
            throw new Exception("Cannot remove from the empty list");
        }

        int removed = head.val;
        head = head.next;
        head.prev = null;
        size--;
        return removed;
    }

    int removeLast() throws Exception{
        if(head == null){
            throw new Exception("Cannot remove from the empty list");
        }
        if(size == 1){
            return removeFirst();
        }
        Node last = get(size - 1);
        int removed = last.val;
        Node secondLast = last.prev;
        secondLast.next = null;
        size--;
        return removed;
    }


    int remove(int index) throws Exception{
        if(index >= size && index < 0){
            throw new Exception("Index out of Bound.");
        }

        if(index == 0){
            return removeFirst();
        }

        if(index == size - 1){
            return removeLast();
        }

        // now get that index
        Node target = get(index);
        int removed = target.val;

        Node prev = target.prev;
        Node next = target.next;
        prev.next = next;
        next.prev = prev;

        size--;
        return removed;
    }

    void reverse(){
        if(head == null){
            return;
        }

        // find the end node and traverse from that node
        Node last = get(size - 1);
        while (last != null){
            System.out.print(last.val + " => ");
            last = last.prev;
        }
        System.out.println("START");
    }
    void display(){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node{
        int val;
        Node prev;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
}
