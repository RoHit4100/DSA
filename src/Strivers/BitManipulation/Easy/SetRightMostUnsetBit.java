package Strivers.BitManipulation.Easy;

public class SetRightMostUnsetBit {
    static int setBit(int n) {
        // code here
        return (n | (n + 1));
    }
}
