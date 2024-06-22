package Strivers.BasicMaths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BasicMaths {
    // kunal's basic maths questions start from here
    // 1. seive method for finding all prime number till n, by using optimal method.

    static void printAllPrimeNumTillN(int n){
        // In this algorithm we will use a binary array for storing the identified non-prime numbers location
        // e.g. if we found that 2 is not prime number then we don't have to find the same for the all the multiples of that number

        boolean[] listOfPrimeNum = new boolean[n + 1];  // initially all the elements of this array will have the false values

        for(int i = 2; i * i <= n; i++){
            if(!listOfPrimeNum[i]){
                for(int index = i * 2; index < n; index+=i){
                    listOfPrimeNum[index] = true;
                }
            }
        }
        for(int i = 2; i < listOfPrimeNum.length; i++){
            if(!listOfPrimeNum[i]){
                System.out.print(i + " ");
            }
        }
    }

    static int mySqrt(int n) {
        long mid = -1;
        long start = 1;
        long end = n;
        while(start <= end){
            mid = start + (end - start) / 2;
            if(mid * mid == n){
                return (int) mid;
            }else if(mid  * mid < n){
                start  = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return (int) Math.round(end);
    }


    static double sqrtByNewtonsRaphson(int n) {
        double x = n;

        double root = 0;
        while(true){
            root = 0.5 * (x + (n/x));
            if(Math.abs(root - x) < 1){
                break;
            }
            x = root;
        }
        return root;
    }


    static void factorsOfN(int n){
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                System.out.print(i + " ");
                if(n / i != i){
                    System.out.print(n / i + " ");
                }
            }
        }
    }


    //leetcode
    static int kthFactor(int n, int k) {
        List<Integer> ls = new ArrayList<>();
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                ls.add(i);
                if(n / i != i){
                    ls.add(n / i);
                }
            }
        }
        if(ls.size() >= k){
            Collections.sort(ls);
            System.out.println(ls);
            return ls.get(k - 1);
        }

        return -1;
    }



    // this is the code which is used to get the lcm and hcf or gcd of two numbers

    static int gcd(int a, int b){
        if(a == 0)
            return b;
        else if(b == 0){
            return a;
        }
        if(a > b){
            return gcd(a % b, b);
        }
        return  gcd(b % a, a);
    }


    // this is the function to find the least common factor of nd be by using some relation between lcm and hcf
    static int lcm(int a, int b){
        return a * b / gcd(a, b);
    }
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the input please");
//        int n = sc.nextInt();
        int n = 12;
//        printAllPrimeNumTillN(n);
//        System.out.println(sqrtByNewtonsRaphson(n));
        factorsOfN(n);
        System.out.println();
        System.out.println(kthFactor(12,  3));
        int a = 7345734;
        int b= 18;
        // gcd or hcf means the greatest number which can divide both a nd b
        System.out.println("GCD of " + a + " and " + b + ": " + gcd(a , b));
        // lcm means the least number which is exactly divisible by a nd b
        System.out.println("LCM of " + a + " and " + b + ": " + lcm(a , b));
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
