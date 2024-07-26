package Kunal.OOPS;

public class Cloning {
    public static void main(String[] args) throws CloneNotSupportedException{
        Human rohit = new Human("rohit", 23);
        // this is a faster way to copy the object.
        // but this is a shallow copy, means if array is there, then this both variables will point to same array or object.
        // to prevent shallow copy, we can use deep copy by modifying the clone function.
        Human twin = (Human) rohit.clone();

        System.out.println(twin.name);
    }
}

class Human implements Cloneable{
    int age;
    String name;
    Human(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}