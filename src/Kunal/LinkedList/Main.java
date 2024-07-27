package Kunal.LinkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception{
//        CustomLL ll = new CustomLL();
//        ll.insertFirst(33);
//        ll.insertFirst(73);
//        ll.insertFirst(83);
//        ll.insertFirst(13);
//        ll.insertFirst(39);
//        ll.insertLast(99);
//        ll.insert(3, 2);
//        System.out.println(ll.deleteFirst());
//        System.out.println(ll.deleteLast());
//        System.out.println(ll.delete(2));
//        System.out.println(ll.getValue(3));
//        ll.display();


        // for doubly LL
        DoublyLL ll = new DoublyLL();
        ll.insertFirst(12);
        ll.insertFirst(32);
        ll.insertFirst(22);
        ll.insertFirst(16);
        ll.insertLast(99);
        ll.insertAfter(2, 2);
        ll.remove(99);
        ll.display();
        System.out.println(ll.find(2));
        ll.displayReverse();
   }
}
