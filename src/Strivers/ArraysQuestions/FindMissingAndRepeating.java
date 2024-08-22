package Strivers.ArraysQuestions;

import java.util.Arrays;

public class FindMissingAndRepeating {
    // now using the hashing
    static int[] findMissingAndRepeating(int[] arr){
        // first create a hash array with size + 1 length
        int[] hash = new int[arr.length + 1];

        // hash the given array
        for (int j : arr) {
            hash[j]++;
        }
        int repeating = -1;
        int missing = -1;

        // now find the index into the hash which has value 2 and 0
        for(int i = 1; i < hash.length;i++){
            if(hash[i] == 0){
                missing = i;
            }else if(hash[i] == 2){
                repeating = i;
            }

            if(repeating == -1 && missing == -1){
                break;
            }
        }
        return new int[] {repeating, missing};
    }
    public static void main(String[] args) {
        int[] arr = {8 ,4 ,1 ,6 ,7 ,2 ,5 ,8 };
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(arr)));
        System.out.println(Arrays.toString(findMissingAndRepeating(arr)));
    }

    // using cyclic sort
    public static int[] findMissingRepeatingNumbers(int []arr) {
        // Write your code here
        // in this problem I will use the Cyclic sort algorithm

        int[] ans = new int[2];
        // first sort the array
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr, i, correct);
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        // now check for the missing and repeating
        for(i = 0; i < arr.length; i++){
            if(arr[i] != i + 1){
                ans[0] = arr[i]; // repeating
                ans[1] = i + 1; // missing
                break;
            }
        }

        return ans;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }





    // find missing in 2D matrix with hashing
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int[] count = new int[size + 1];  // To count occurrences of each number
        int a = -1, b = -1;

        // Count the frequency of each number in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j]]++;
            }
        }

        // Find the repeating (a) and missing (b) numbers
        for (int i = 1; i <= size; i++) {
            if (count[i] == 0) {
                b = i;  // Missing number
            } else if (count[i] == 2) {
                a = i;  // Repeating number
            }
        }

        return new int[]{a, b};
    }
}
