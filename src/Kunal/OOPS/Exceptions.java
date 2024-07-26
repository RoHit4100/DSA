package Kunal.OOPS;

public class Exceptions {
    // Exception and error this both thing are different but they both Inherit throwable class
    // Error is caused by lack of resources or something else, which can lead to stopping ur program,
    // means non-recoverable, or that cannot be stopped.
    // e.g. StackOverflow, IndexOutOfBound
    // Exception in other hand is recoverable, and can be managed by the programmer.
    // e.g. Arithmetic exception divide by 0 exception, Null pointer exception


    /// exception are two types, checked or unchecked
    // checked => checked at the compile time, e.g. opening a file that doesn't exist in the first place
    // unchecked => arithmetic exception, cannot be checked until program is running.


    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
//            int c = a / b;
            divide(a, b);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("This will always execute");
        }
    }

    static void divide(int a, int b) throws Exception{
        if (b == 0) {
            throw new Exception("Cannot divide by 0");
        }
        else{
            System.out.println(a/b);
        }
    }
}


