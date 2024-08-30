package Strivers.Recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPatterns {
    // first pattern is take not take.
    // second pattern is print only one answer
    // third pattern is return the count

    // 1. take and not take, this pattern is mainly used to print subsequences
    private static List<List<Integer>> takeNotTake(int[] arr){
        // in this question we have to find the all subsequence of given array.
        // if the size is n, then subsequences will be 2^n.

        List<List<Integer>> ans = new ArrayList<>();
        int count = subsequences(ans, new ArrayList<Integer>(), arr, 0);
        System.out.println(count);
        return ans;
    }

    // function to add answers into the ans list
    private static int subsequences(List<List<Integer>> ans, List<Integer> subsequence, int[] arr, int index){
        if(index == arr.length){
            ans.add(new ArrayList<>(subsequence));
            return 1;
        }

        // first take the current index, means add that into subsequence
        subsequence.add(arr[index]);
        // call same function after taking
        int left = subsequences(ans, subsequence, arr, index + 1);

        // now comes the part known as not take, means remove the added element from the subsequence
        subsequence.remove(subsequence.size() - 1); // removing the last added element, or current added element
        // call the same function after not taking the element
        int right = subsequences(ans, subsequence, arr, index + 1);
        return left + right;
    }

    // 1. pick and not pick for finding the subsequences which have sum k
    private static List<List<Integer>> takeNotTake2(int[] arr, int k){
        // if the size is n, then subsequences will be 2^n.

        List<List<Integer>> ans = new ArrayList<>();
        findSubsequencesWithSumK(ans, new ArrayList<Integer>(), arr, 0, 0, k);
        return ans;
    }

    private static void findSubsequencesWithSumK(List<List<Integer>> ans, List<Integer> subsequence, int[] arr, int index, int sum, int k){
        if(sum == k || index >= arr.length){
            if(sum == k){
                ans.add(new ArrayList<>(subsequence));
            }
            return;
        }
        sum = sum + arr[index]; // take
        subsequence.add(arr[index]);

        findSubsequencesWithSumK(ans, subsequence, arr, index + 1, sum, k);

        // not take
        sum = sum - arr[index];
        subsequence.remove(subsequence.size() - 1);
        findSubsequencesWithSumK(ans, subsequence, arr, index + 1, sum, k);
    }

    // 2. In this pattern we just have to print a single answer, of-course we cant print a specific ans
    private static List<Integer> printOneAnswer(int[] arr, int target){
        // here we can use the booleans values to stop further recursion calls
        List<Integer> ans = new ArrayList<>();
        addOnlyOne(ans, 0, 0, arr, target);
        return ans;
    }

    private static boolean addOnlyOne(List<Integer> list, int index, int sum, int[] arr, int target){
        if(target == sum || index >= arr.length){
            // return true if subsequence with sum has found
            return target == sum;
        }

        // first check if target has less than 0 or not
        // take it
        list.add(arr[index]); // add into the subsequence
        sum += arr[index]; // add current item into the sum, because we have taken that element
        boolean found = addOnlyOne(list, index + 1, sum, arr, target); // call after taking it
        if(found){ // check if subsequence is found or not
            return true; // if found then return from here, there is no need to call further recursion calls
        }
        list.remove(list.size() - 1); // if not found then try after not taking it
        sum -= arr[index]; // remove current item from sum
        return addOnlyOne(list, index + 1, sum, arr, target); // return whatever you get
    }


    // 3. pattern is returning the count of total subsequences with sum k
    static int getCountOfSubSequenceWithSumK(int[] arr, int k){
        return findCount(arr, 0, 0, k);
    }

    private static int findCount(int[] arr, int sum, int index, int k){
        if(sum == k || index >= arr.length){
            if(sum == k){
                return 1;
            }
            return 0;
        }

        sum += arr[index];
        int left = findCount(arr, sum, index + 1, k);

        // right call
        sum -= arr[index];
        int right = findCount(arr, sum, index + 1, k);
        return left + right;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1,5,2};
        List<List<Integer>> ans = takeNotTake(arr);

        ans.forEach(System.out::println);

        System.out.println("subsequence with sum " + 5);
        List<List<Integer>> ans1 = takeNotTake2(arr, 5);

        ans1.forEach(System.out::println);


        System.out.println("print only one answer pattern");
        System.out.println(printOneAnswer(arr, 5));

        System.out.println("count of total subsequence with sum k");
        System.out.println(getCountOfSubSequenceWithSumK(arr, 5));
    }
}
