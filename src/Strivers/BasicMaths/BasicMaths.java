package Strivers.BasicMaths;

import java.util.Scanner;

public class BasicMaths {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input please");
        int n = sc.nextInt();
    }

    static int CountDigits(int n){
        // int count = 0;
        // while (n > 0){
        //     n /= 10;
        //     count++;
        // }
        // return count;


        return (int)(Math.log10(n) + 1);

        // String s = Integer.toString(n);
        // return s.length();
    }

    static int getTheReverse(int n){
        int original = n;
        int reverse = 0;

        while(n > 0){
            int rem = n % 10;
            if(rem == 0){
                n /= 10;
                if(n % 10 == 0)
                    continue;
                else
                    reverse = reverse * 10 + rem;
                continue;
            }
            reverse = reverse * 10 + rem;
            n /= 10;
        }
        return reverse;
    }


    public static boolean palindromeNumber(int n){
        // Write your code here.
        long original = n;
        long reverse = 0;
        while(n > 0){
            int lastDigit = n % 10;
            reverse = reverse * 10 + lastDigit;
            n /= 10;
        }
        if(reverse == original)
            return true;
        return false;
    }


    static boolean check(int n){
        int original = n;
        int armNum = 0;
        int totalDigits = (int) (Math.log10(n) + 1);
        while(n > 0){
            int singleDigit = n % 10;
            // if(singleDigit == 0){
            // 	n /= 10;
            // 	continue;
            // }
            armNum += Math.pow(singleDigit, totalDigits);
            n /= 10;
        }

        return original == armNum;
    }

    public static int gcdByEuclidean(int a, int b){

        while(a > 0 && b > 0){
            if(a > b)
                a %= b;
            else
                b %= a;

        }
        if(a == 0){
            return b;
        }else{
            return a;
        }
    }
}
