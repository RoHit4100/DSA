package Strivers.BinarySearchQuestions.BSOn1D.BSOnNumbers;

import java.util.ArrayList;
import java.util.Arrays;

public class FindKThElementInTwoSortedArr {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        // Write your coder here
        if(k > n + m){
            return k;
        }
        int count = 1;
        int i = 0;
        int j = 0;

        while(i < n && j < m){
            if(arr1.get(i) < arr2.get(j)){
                System.out.println("i " + i);
                if(count == k){
                    return arr1.get(i);
                }
                i++;
            }else{
                System.out.println("j " + j);
                if(count == k){
                    return arr2.get(j);
                }
                j++;
            }
            count++;
        }

        while(i < n){
            if(count == k){
                return arr1.get(i);
            }
            i++;
        }

        while(j < m){
            if(count == k){
                return arr2.get(j);
            }
            j++;
        }
        return k;
    }


    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(2, 3, 6, 7, 9));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 4, 8, 10));
        int k = 4;
        System.out.println(kthElement(arr1, arr2, arr1.size(), arr2.size(), k));
    }
}
