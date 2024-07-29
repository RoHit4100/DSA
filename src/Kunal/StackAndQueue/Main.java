package Kunal.StackAndQueue;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
//        CustomStack<Integer> stack = new CustomStack<>();
//
//        stack.add(12);
//        stack.add(52);
//        stack.add(56);
//        stack.add(11);
//        stack.add(10);
//
//        stack.display();
//        System.out.println(stack.remove());
//        stack.display();
//        System.out.println(stack.peek());
//        stack.display();
//
//        CustomStack<String> s = new CustomStack<>();
//        s.add("Rohit");
//        s.add("krushna");
//        s.display();
//        System.out.println(s.remove());
//        s.display();


        CircularQueue q = new CircularQueue();
        q.add(12);
        q.add(10);
        q.add(52);
        q.add(84);
        q.display();
        System.out.println(q.remove());
        q.display();
        q.add(133);
        q.display();
    }
}
