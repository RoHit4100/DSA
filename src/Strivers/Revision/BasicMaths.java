package Strivers.Revision;

import java.util.ArrayList;
import java.util.List;

public class BasicMaths {
    static int gcdWithBruteForce(int n1, int n2){
        for(int i = Math.min(n1, n2); i >= 2; i--){
            if(n1 % i == 0 && n2 % i == 0){
                return i;
            }
        }
        return 1;
    }

    static int gcdWithEuclideanTheorem(int n1, int n2){
        // In this theorem we will perform modulo operation to greater number and at then if one of the number becomes
        // the 0 then the remaining number will be the gcd
        while (n1 > 0 && n2 > 0){
            if(n1 > n2){
                n1 %= n2;
            }else{
                n2 %= n1;
            }
        }

        // and now check which one has become the zero, and the return the other number
        if(n1 == 0){
            return n2;
        }
        return n1;
    }
    public static void main(String[] args) {
        int n = 11010000;
//        printDivisors(36);
//        primeOrNOt(11);
//        System.out.println(gcdWithBruteForce(20, 1));
        System.out.println(gcdWithEuclideanTheorem(40, 20));
    }

    static void countDigits(int n){
        System.out.println((int)Math.log10(n) + 1);
    }

    static void printDivisors(int n){
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                list.add(i);
                if(n / i == i){
                    continue;
                }
                list.add(n / i);
            }
        }
        System.out.println(list);
    }


    static void primeOrNOt(int n){
        boolean prime = true;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                prime = false;
            }
        }
        if(!prime){
            System.out.println("Not prime number");
        }else {
            System.out.println("prime number");
        }
    }

    static void reverseWithoutZeros(int n){
        StringBuilder number = new StringBuilder(String.valueOf(n));
        String ans = number.reverse().toString().replaceFirst("^0+", "");
        System.out.println(ans);
    }
}
