package Kunal.OOPS;

public class Singleton {
    // static variables doesn't depend on the object so u cant use this keyword in any static method of a class.`
    // in java static block is only runs for the first initialization of object of that class.
    // outside classes cannot be static only inside classes can be static.

    // singleton class means only one object is allowed to create.
    // static methods are resolve in compile time.

    String name;
    private Singleton(){

    }

    private static Singleton instance;

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
