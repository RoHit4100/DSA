package Strivers.BitManipulation.Medium;

public class XorOfLtoR {
    // brute force
    public static int findXOR(int l, int r) {
        int xor = 0;
        for(int i = l; i <= r; i++){
            xor ^= i;
        }
        return xor;
    }

    // optimal solution
    // this solution will be using some pattern
    private static int findXorTillN(int n){
        // there will be four conditions
        if(n % 4 == 1){
            return 1;
        }
        if(n % 4 == 2){
            return n + 1;
        }
        if(n % 4 == 3){
            return 0;
        }
        return n;
    }

    public static int findXOROptimal(int l, int r) {
        int left = findXorTillN(l);
        int right = findXorTillN(r);
        return left ^ right;
    }
}
