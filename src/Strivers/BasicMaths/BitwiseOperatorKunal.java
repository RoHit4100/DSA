package Strivers.BasicMaths;

public class BitwiseOperatorKunal {
    public static void main(String[] args){
        int n = 100;
//        helperForOddEven(n);
        // find the unique number which is present in the array, by using bitwise operator, so here we will use the XOR bitwise operator

//        int[] arr = {2,34,2,34,23,7,8,6,7,9,6,8,9};
//
//        findUnique(arr);
        // find nth magic number with user suggested base

//        magicNumber(5, 5);


        // find the number of bit of a number in binary
        findTotalBitOfNum(n);
        findTotalDigitsOfNum(n);
    }

    static void findTotalDigitsOfNum(int n){
        System.out.println((int)(Math.log10(n) + 1));
    }
    static void findTotalBitOfNum(int n){
        int original = n;
        int count = 0;
        while(n > 0){
            count++;
            System.out.print((n & 1) + " ");
            n = n >> 1;
        }
        System.out.println();
        System.out.println("the total number of bit in " + original + " is " + count);
    }
    static void findUnique(int[] arr){
        int uniqueNum = 0;
        for(int i = 0; i < arr.length; i++){

            uniqueNum ^= arr[i];
        }
        System.out.println(uniqueNum);
    }

    static void magicNumber(int base, int n){
        int actualBase = base;
        int magicNum = 0;
        while(n > 0){
            int lastBit = n & 1;
            magicNum += (lastBit * base);
            base *= actualBase;
            n = n >> 1;

        }
        System.out.println(magicNum);
    }
    static void helperForOddEven(int n){
        if(checkOddOrEven(n))
            System.out.println("Odd");
        else
            System.out.println("Even");
    }
    static boolean checkOddOrEven(int n){
        return (n & 1) == 1;
    }
}
