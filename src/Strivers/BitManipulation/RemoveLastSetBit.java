package Strivers.BitManipulation;

public class RemoveLastSetBit {
    // in this problem we have to remove the first right most set bit
    public static void main(String[] args) {
        int a = 84;
        int removeSetBit =  a & (a - 1);
        System.out.println(removeSetBit);
    }
}
