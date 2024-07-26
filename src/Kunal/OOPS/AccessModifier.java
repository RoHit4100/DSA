package Kunal.OOPS;

public class AccessModifier {
    private int n = 10;
    // public can be use anywhere
    // private can be only use in that particular class, not even in the same file of different class or subclass
    // protected can use anywhere except in different package without a subclass, means if u want to use protected u can use if u want
    // to use that element in only subclasses.

    // default access modifier can be use only in the same package, it cant be use in different packages.

    // final keyword prevents override, when u use it with method.
    // final keyword also prevents the inheritance.
}