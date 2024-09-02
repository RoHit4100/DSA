package Strivers.Maths.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPrimesForQueries {
    // first of all we have been given List<List>> of queries, int those list, there will be right and left is given so we have to find the
    // all the prime number which lies into that range

    // brute force approach will be going through all the queries
    static void printPrimesForAllQueries(List<List<Integer>> queries){
        // go through each query
        for(List<Integer> query: queries){
            // left will be the first item of list, and right will be second
            int left = query.get(0);
            int right = query.get(1);

            // now go from left to right and print the prime number
            System.out.print(left + " ," + right + " :");
            for(int i = left; i <= right; i++){
                if(isPrime(i) && i != 1){
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }



    // better approach will be using sieve method to get the prime
    static void printPrimesForAllQueriesBetter(List<List<Integer>> queries){
        // get the seive array
        int[] arr = new int[100 + 1];
        seive(arr.length, arr);
        // go through each query
        for(List<Integer> query: queries){
            // left will be the first item of list, and right will be second
            int left = query.get(0);
            int right = query.get(1);

            // now go from left to right and print the prime number
            System.out.print(left + " ," + right + " :");
            for(int i = left; i <= right; i++){
                // get the prime number by using seive array
                if(arr[i] == 1 && i != 1){
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }

    static void seive(int n, int[] arr){
        Arrays.fill(arr, 1);

        // now create the seive
        for(int i = 2; i * i < n; i++){
            // mark 0 only if it is 1
            if(arr[i] == 1){
                // mark all multiples of i as 0
                for(int j = i * i; j < n; j+=i){
                    arr[j] = 0;
                }
            }
        }
    }


    static void printCountOfRange(List<List<Integer>> queries){
        // get the seive which have the count till certain index
        int[] count = new int[101];
        seiveWithCount(count);

        // go through each query
        for(List<Integer> query: queries){
            // left will be the first item of list, and right will be second
            int left = query.get(0);
            int right = query.get(1);

            // now we have to find the count of prime number in between this range
            int leftCount = count[left - 1];
            int rightCount = count[right];
            System.out.println(rightCount - leftCount);
        }
    }
    // now the optimal solution, for getting the count of prime number in between that range
    // here we have to use prefix sum
    static void seiveWithCount(int[] seive){
        // now I have to traverse from 2 till length of the seive and replace the current index with the count present at that point
        // first create the sieve
        Arrays.fill(seive, 1);
        seive[0] = 0;
        seive[1] = 0;
        for(int i = 2; i * i < seive.length; i++){
            if(seive[i] == 1){
                // mark the multiples as 1
                for(int j = i * i; j < seive.length; j+=i){
                    seive[j] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(seive));

        // now use the concept of prefix sum
        int count = 0;
        for(int i = 2; i < seive.length; i++){
            count += seive[i];
            seive[i] = count;
        }
//        System.out.println(Arrays.toString(seive));
    }


    public static void main(String[] args) {
        List<List<Integer>> queries = new ArrayList<>();

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 10));
        queries.add(list);
        List<Integer> list1 = new ArrayList<>(Arrays.asList(10, 100));
        queries.add(list1);
        List<Integer> list2 = new ArrayList<>(Arrays.asList(30, 50));
        queries.add(list2);

        printPrimesForAllQueries(queries);
        System.out.println();
        printPrimesForAllQueriesBetter(queries);

        System.out.println();
        printCountOfRange(queries);
    }
}
