package Strivers.ArraysQuestions;

import java.util.*;

public class NextPermutation {
    // this is the problem of finding next permutation of a permutation in a given array

    // optimize solution
    // here we will not find all permutations instead we will find the break point, then find the first greater element
    // then just reverse from next greater element
    static int[] nextGreaterPermutation(int[] arr){
        // first assign the index as -1 to check if given array is already greatest or not
        int index = -1;
        int n = arr.length;

        // find the break point
        for(int i = n - 2; i >= 0; i--){
            if(arr[i] < arr[i + 1]){
                index = i;
                break;
            }
        }

        // now check if index is modified or not
        if(index == -1){
            reverse(arr, 0, n - 1);
        }

        // now find the first greater element than the current index element
        // and swap that element with current element
        for(int i = n - 1; i >= 0; i--){
            if(arr[i] > arr[index]){
                swap(arr, i, index);
                break;
            }
        }

        // now reverse from index + 1 to end
        reverse(arr, index + 1, n - 1);
        return arr;
    }

    private static void reverse(int[] arr, int start, int end){
        while (start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(nextPermutation(arr)));
        System.out.println(Arrays.toString(nextGreaterPermutation(arr)));

    }

    // for this problem u have to solutions, first is brute force in which u will find all the permutations and return the next permutation
    // of given permutation
    // Brute force approach
    static int[] nextPermutation(int[] arr){
        List<List<Integer>> list = new ArrayList<>();
        getPermutations(arr, 0,  list);


        Collections.sort(list, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> list1, List<Integer> list2) {
                for (int i = 0; i < list1.size(); i++) {
                    int cmp = list1.get(i).compareTo(list2.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return 0;
            }
        });
        System.out.println(list);
        // Find the current permutation and return the next one
        for (int i = 0; i < list.size(); i++) {
            List<Integer> current = list.get(i);
            boolean isSame = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != current.get(j)) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                if (i == list.size() - 1) {
                    // If it's the last permutation, return the first permutation
                    return listToArray(list.get(0));
                } else {
                    // Return the next permutation
                    return listToArray(list.get(i + 1));
                }
            }

        }
        return arr;
    }

    static int[] listToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    static void getPermutations(int[] arr, int start, List<List<Integer>> list){
        if(start == arr.length){
            // now add items of array here, in separate list
            List<Integer> current = new ArrayList<>();
            for(int num: arr){
                current.add(num);
            }
            list.add(current);
            return;
        }


        for(int i = start; i < arr.length; i++){
            // swap two start and i
            swap(arr, start, i);

            // now perform recursion by increasing start
            getPermutations(arr, start + 1, list);

            // now backtrack, means again swap, i start
            swap(arr, i, start);
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
