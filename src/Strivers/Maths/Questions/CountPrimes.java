package Strivers.Maths.Questions;

import java.util.Arrays;

public class CountPrimes {
    // this will be better solution
    public int countPrimes(int n) {
        if(n <= 2){
            return 0;
        }
        // here I can use sieve method,
        int[] primes = new int[n];
        Arrays.fill(primes, 1);
        getPrimesBySieve(n, primes);
        // now count the primes numbers
        int count = 0;
        for(int i = 2; i< primes.length; i++){
            if(primes[i] == 1){
                count++;
            }
        }
        return count;
    }

    private void getPrimesBySieve(int n, int[] arr){
        for(int i = 2; i * i < n; i++){
            if(arr[i] == 1){
                for(int j = i * i; j < n; j+=i){
                    arr[j] = 0;
                }
            }
        }
    }
}
