package Strivers.ArraysQuestions;

import java.util.*;

public class UnionOfTwoArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 6, 7};
//        System.out.println(findUnion(arr1, arr2));
        System.out.println(findUnionBruteForce(arr1, arr2));
    }
    // for brute force approach we can just simply store elements of both array in set, which will only store all the unique elements
    // and at the element add all those elements into the array list for returning purpose
    static List<Integer> findUnionBruteForce(int[] a, int[] b){
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int n = a.length;
        int m = b.length;
        int i = 0;
        int j = 0;

        while (i < n && j < m){
            // check first are those equal or not;
            if(a[i] <= b[j]){
                set.add(a[i]);
                i++;
            }else{
                set.add(b[j]);
                j++;
            }
        }

        while (i < n){
            set.add(a[i]);
            i++;
        }
        while (j < m) {
            set.add(b[j]);
            j++;
        }

        // now in the end add all those element into the list, set store all the elements in increasing order
        for(Integer num: set){
            ans.add(num);
        }
        return ans;
    }

    // this both solutions are optimal solutions
    static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m){
        // add your code here
        ArrayList<Integer> list = new ArrayList<>();

        // I will use two pointer method and insert into the ans
        int i = 0, j = 0;

        while(i < n && j < m){
            if(arr1[i] <= arr2[j]){
                if(!list.contains(arr1[i])){
                    list.add(arr1[i]);
                }
                i++;
            }else{
                if(!list.contains(arr2[j])){
                    list.add(arr2[j]);
                }
                j++;
            }
        }

        while(i < n){
            if(!list.contains(arr1[i])){
                list.add(arr1[i]);
            }
            i++;
        }

        while(j < m){
            if(!list.contains(arr2[j])){
                list.add(arr2[j]);
            }
            j++;
        }

        return list;
    }


    static ArrayList<Integer> findUnion(int arr1[], int arr2[]) {
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0, j = 0;
        Integer lastAdded = null; // To keep track of the last added element to avoid duplicates
        int n = arr1.length;
        int m = arr2.length;
        // Iterate over both arrays
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (lastAdded == null || arr1[i] != lastAdded) {
                    list.add(arr1[i]);
                    lastAdded = arr1[i];
                }
                i++;
            } else if (arr1[i] > arr2[j]) {
                if (lastAdded == null || arr2[j] != lastAdded) {
                    list.add(arr2[j]);
                    lastAdded = arr2[j];
                }
                j++;
            } else {
                // Both elements are the same
                if (lastAdded == null || arr1[i] != lastAdded) {
                    list.add(arr1[i]);
                    lastAdded = arr1[i];
                }
                i++;
                j++;
            }
        }

        // Add remaining elements from arr1
        while (i < n) {
            if (lastAdded == null || arr1[i] != lastAdded) {
                list.add(arr1[i]);
                lastAdded = arr1[i];
            }
            i++;
        }

        // Add remaining elements from arr2
        while (j < m) {
            if (lastAdded == null || arr2[j] != lastAdded) {
                list.add(arr2[j]);
                lastAdded = arr2[j];
            }
            j++;
        }

        return list;
    }
}
