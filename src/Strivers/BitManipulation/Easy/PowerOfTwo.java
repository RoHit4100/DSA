package Strivers.BitManipulation.Easy;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        // check if there is only 1 set bit is present or not
        if(n <= 0){
            return false;
        }
        if((n & (n - 1)) == 0){
            return true;
        }
        return false;
    }
}
