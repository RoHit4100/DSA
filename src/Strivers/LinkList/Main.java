package Strivers.LinkList;

public class Main {
    public static void main(String[] args) throws Exception {
        SinglyLL list = new SinglyLL();
        list.insertFirst(34);
        list.insertFirst(14);
        list.insertFirst(32);
        list.insertFirst(12);
        list.insertFirst(88);
        list.insertFirst(39);
        list.insertLast(1);
        list.insertLast(6);
        list.insertLast(7);
        list.insertLast(8);
        list.insertLast(90);
        list.display();
        System.out.println();
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        list.display();
        System.out.println(list.remove(3));
        System.out.println();
        list.display();
        list.reverse();
        list.display();
    }
}
