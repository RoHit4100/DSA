package Strivers.BitManipulation.Easy;

public class SingleNum {
    public int findSingle(int[] arr){
        int xor = 0;
        for(int num: arr){
            xor ^= num;
        }
        return xor;
    }
}
