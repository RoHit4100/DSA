package Kunal.OOPS;

public abstract class AbClass {
    abstract void greetings();
}

class Main2{
    // abstract method cannot be static.
    public static void main(String[] args) {
        A a = new A();
        a.greetings();
    }
}
class A extends AbClass{
    @Override
    void greetings() {
        System.out.println("Hello World");
    }
}