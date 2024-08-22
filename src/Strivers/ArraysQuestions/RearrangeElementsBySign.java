package Strivers.ArraysQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeElementsBySign {
    // brute force approach in which we will have the complexity of O(2n) and space complexity as O(n)
    static int[] rearrangeElementsBruteForce(int[] arr){
        // in this problem we have to arrange -ve number at odd index and +ve numbers at even index
        // for that lets just store all the elements into the two separate array by traversing through original array
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for(int num: arr){
            if(num < 0){
                negative.add(num);
            }else{
                positive.add(num);
            }
        }
        // now store all the negative numbers in odd index and vice versa
        // run this loop till only length / 2, because we are multiplying index
        for(int i = 0; i < arr.length / 2; i++){
            // index for positive index will be i * 2, e.g. 2 * 2 = 4
            arr[i * 2] = positive.get(i);
            // index for negative will be the odd index
            arr[i * 2 + 1] = negative.get(i);
        }
        return arr;
    }


    // this is not quite optimize approach as it will only reduce the time complexity to O(n) and space complexity will be the same
    static int[] rearrangeArray(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        // first we will create array with same size to store all those elements index wise and return at the end of the function
        int[] ans = new int[arr.length];

        int even = 0, odd = 1;
        // now traverse through array
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                ans[odd] = arr[i];
                odd += 2;
            }else{
                ans[even] = arr[i];
                even += 2;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {3,-2,2,-1,4};
//        System.out.println(Arrays.toString(rearrangeElementsBruteForce(arr)));
//        System.out.println(Arrays.toString(rearrangeArray(arr)));
        System.out.println(Arrays.toString(alternateNumbers(arr)));
    }

    // this is another variety of the rearranging problem where no of positive and negative are not same
    public static int[] alternateNumbers(int[] arr) {
        // so here we will first try our brute force approach to replace the elements present in the original array
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        // now add all the -ve and +ve elements into their respective lists
        for(int num: arr){
            if(num < 0){
                negative.add(num);
            }else{
                positive.add(num);
            }
        }

        // now I have to perform for loop to replace the elements till the min size of the both list
        if(negative.size() < positive.size()){
            for(int i = 0; i < negative.size(); i++){
                arr[i * 2] = positive.get(i);
                arr[i * 2 + 1] = negative.get(i);
            }
            // now add replace the rest of the element of remaining list in the array
            int nSize = negative.size();
            int index = nSize * 2;
            for(int j = nSize; j < positive.size(); j++){
                arr[index] = positive.get(j);
                index++;
            }
        }else{
            for(int i = 0; i < positive.size(); i++){
                arr[i * 2] = positive.get(i);
                arr[i * 2 + 1] = negative.get(i);
            }

            // now add replace the rest of the element of remaining list in the array
            int pSize = positive.size();
            int index = pSize * 2;
            for(int j = pSize; j < negative.size(); j++){
                arr[index] = negative.get(j);
                index++;
            }
        }

        return arr;
    }
}
