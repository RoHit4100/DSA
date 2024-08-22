package Strivers.ArraysQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    // optimal solution
    static int longestSequenceOptimal(int[] arr){
        // here we will use the hash set for checking the previous and next element of the current number in the sequence
        Set<Integer> set = new HashSet<>();

        // first insert all the elements into the hash set
        for(int num: arr){
            set.add(num);
        }

        int length = 0;

        // now comes the important part which is checking the sequence with constant time, now we will just traverse through hash array
        for(Integer num: set){
            // now check whether current number previous exist into the set, if yes then don't do anything
            if(!set.contains(num - 1)){
                // here we will check the next number of the current number

                int count = 1;
                // we will increase the number and check if exist in the set or not
                while (set.contains(num + 1)){
                    // if exist then just increase the count
                    count++;
                    // and also increase the number itself
                    num++;
                }

                length = Math.max(count, length);
            }
        }
        return length;
    }
    public static void main(String[] args) {
        int[] arr = {5, 8, 3, 2, 1, 4};
        System.out.println(longestSequence(arr));
        System.out.println(longestSequenceBetter(arr));
        System.out.println(longestSequenceOptimal(arr));
    }

    // in this problem we will find the longest consecutive sequence

    // brute force approach
    static int longestSequence(int[] arr){
        int longest = 0;
        for (int num : arr) {
            // now take a count which only increase when next number of sequence is found
            // initially count will be 1, as 1 sequence will be always there
            int count = 1;
            int x = num; // because of all positives
            // here we will perform linear search for each increment in x
            while (linearSearch(arr, x + 1)) {
                // if x + 1 is found, find the next number
                x += 1;
                // and increase the count by 1
                count++;
            }
            // take the max
            longest = Math.max(count, longest);
        }

        return longest;
    }

    private static boolean linearSearch(int[] arr, int target){
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == target) {
                return true;
            }
        }
        return false;
    }



    // better approach will use the sorted array for finding the longest subsequence
    static int longestSequenceBetter(int[] arr){
        Arrays.sort(arr);

        // now we will iterate through array only once to find the longest
        int longest = 1;
        int lastSmaller = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            // now first check if last smaller is one lesser than the current element or not
            if(arr[i] - 1 == lastSmaller){
                count += 1;
                lastSmaller = arr[i];
            }else if(arr[i] != lastSmaller){
                lastSmaller = arr[i];
                count = 1;
            }

            longest = Math.max(count, longest);
        }

        return longest;
    }
}
