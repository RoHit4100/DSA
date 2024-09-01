package Strivers.BitManipulation;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        System.out.println(a + "   " + b);
        // swap with using 3rd variable
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + "   " + b);
    }
}
