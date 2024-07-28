package Kunal.LinkedList.Questions;

public class Main {
    public static void main(String[] args) {
        LLQuestions first = new LLQuestions();
        first.insertLast(12);
        first.insertLast(32);
        first.insertLast(42);
        first.insertLast(69);
        first.display();

        LLQuestions second = new LLQuestions();
        second.insertLast(1);
        second.insertLast(2);
        second.insertLast(3);
        second.insertLast(4);
        second.insertLast(5);
        second.insertLast(6);
        second.display();

        LLQuestions ans = LLQuestions.merge(first, second);
        ans.display();

        boolean a= LLQuestions.findHappyOrNot(19);
        System.out.println(a);
    }
}
