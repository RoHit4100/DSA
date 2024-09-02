package Strivers.Maths.Questions;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorizationUsingSeive {
    // brute force approach will be finding all the prime factors on n
    static List<Integer> findPrimeFactors(int n) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                while(n % i == 0){
                    ans.add(i);
                }
            }
        }
        if(n > 1){
            ans.add(n);
        }
        return ans;
    }


    // Max limit for sieve
    static final int MAX = 200000;

    // Sieve function to precompute smallest prime factors
    static int[] sieve() {
        int[] arr = new int[MAX + 1];

        // Initialize each index with its value
        for (int i = 2; i <= MAX; i++) {
            arr[i] = i;
        }

        // Sieve algorithm to populate smallest prime factors
        for (int i = 2; i * i <= MAX; i++) {
            if (arr[i] == i) { // i is a prime number
                for (int j = i * i; j <= MAX; j += i) {
                    if (arr[j] == j) {
                        arr[j] = i; // Assign smallest prime factor
                    }
                }
            }
        }
        return arr;
    }

    // Function to find prime factors of a given number N
    static List<Integer> findPrimeFactors1(int n) {
        int[] arr = sieve();
        List<Integer> list = new ArrayList<>();

        while (n != 1) {
            list.add(arr[n]);
            n /= arr[n];
        }

        return list;
    }
}
