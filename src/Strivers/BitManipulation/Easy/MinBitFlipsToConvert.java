package Strivers.BitManipulation.Easy;

public class MinBitFlipsToConvert {
    public int minBitFlips(int start, int goal) {
        if(start == goal){
            return 0;
        }
        // first we wil find the xor of two numbers and the result will be containing
        // the number bit needs to change, which are the set bits
        int ans = start ^ goal;
        int count = 0; // to count the number of set bits
        while(ans != 0){
            count += (ans & 1); // add the last bit into ans
            ans >>= 1; // right shift the ans, which will delete the last bit
        }
        return count; // return the count
    }
}
