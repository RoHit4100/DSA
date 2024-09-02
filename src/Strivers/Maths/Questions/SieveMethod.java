package Strivers.Maths.Questions;

import java.util.Arrays;

public class SieveMethod {
    // sieve without optimization
    static boolean[] seiveWithoutOptimization(int n){
        // it will take a number, and return a boolean array with all prime indexes marked as false, and other as true
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true); // initially consider that every number is prime
        sieve[0] = false; // 0 and 1 are not prime
        sieve[1] = false;
        // now travel from 2 to n, and mark all the multiples of prime number as true
        for(int i = 2; i * i <= n; i++){
            if(sieve[i]){ // mark only if that index is prime
                // mark all the multiples as true
                for(int j = i * 2; j <= n; j+=i){ // move j by i steps after each iteration
                    sieve[j] = false;
                }
            }
        }

        return sieve;
    }

    // seive with optimization
    static boolean[] seiveOptimized(int n){
        boolean[] primeIndexes = new boolean[n + 1];

        // fill every thing as true
        Arrays.fill(primeIndexes, true);
        // marks 0th and first index as false
        primeIndexes[0] = false;
        primeIndexes[1] = false;

        for(int i = 2; i * i <= n; i++){ // here we are going till square root of i, because in the inside loop we are actually starting from i * i
            if(primeIndexes[i]){
                for(int j = i * i; j <= n; j+=i){ // start from i * i, as before indexes are marked by previous indexes 5 * 2, 5 * 3.....
                    primeIndexes[j] = false;
                }
            }
        }

        // return array
        return primeIndexes;
    }
    public static void main(String[] args) {
        boolean[] primes = seiveWithoutOptimization(100);
        int index = 0;
        for(boolean prime: primes){
            if(prime){
                System.out.print(index + " ");
            }
            index++;
        }

        System.out.println();
        boolean[] p = seiveOptimized(100);
        int i = 0;
        for(boolean prime: p){
            if(prime){
                System.out.print(i + " ");
            }
            i++;
        }

    }
}
