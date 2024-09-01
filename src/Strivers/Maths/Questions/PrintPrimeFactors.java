package Strivers.Maths.Questions;

import java.util.ArrayList;
import java.util.List;

public class PrintPrimeFactors {
    public int[] AllPrimeFactorsOptimal(int n){
        // code here
        // this is the most optimal approach
        List<Integer> list = new ArrayList<>();
        // run this loop till root of n
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                // add that element into list
                list.add(i);
                while(n % i == 0){
                    // reduce n, with i, till its possible
                    n /= i;
                }
            }
        }
        if(n != 1){ // in the end we will travel till square of n, check if n != 1, then add that number into list
            list.add(n);
        }
        // convert the list into array
        int[] ans = new int[list.size()];
        int i = 0;
        for(int num: list){
            ans[i] = num;
            i++;
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(findPrimeFactors(35));
    }

    // extreme brute force approach will be finding all the factors and then checking if that factor is prime or not
    static List<Integer> findPrimeFactors(int n){
        List<Integer> list = new ArrayList<>();

        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                if(isPrime(i)){ // check if current number is prime or not
                    list.add(i); // if prime then add into list
                }
                if(n / i != i && isPrime(n / i)){ // check the whatever number we are multiplying that is also prime or not
                    // if prime then add into the list
                    list.add(n / i);
                }
            }
        }

        return list;
    }

    private static boolean isPrime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }


    // optimal solution
    public int[] AllPrimeFactors(int n){
        // this is the most optimal approach
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(n % i == 0){
                // add that element into array, as that number is definitely going to be prime.
                list.add(i);
                // divide the n by i, as much time as possible
                while(n % i == 0){
                    n /= i; // reduce the n by dividing i
                }
            }
        }

        // convert the list into array
        int[] ans = new int[list.size()];
        int i = 0;
        for(int num: list){
            ans[i] = num;
            i++;
        }

        return ans;
    }
}
