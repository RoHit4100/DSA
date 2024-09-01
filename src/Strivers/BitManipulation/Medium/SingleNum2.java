package Strivers.BitManipulation.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNum2 {
    // brute force approach will use the HashMap to store the number and its frequency
    public int singleNumber(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // first traverse through the arr, and store the frequency of its respective num
        for(int num: arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // now traverse through the map and find a number with frequency as 1
        for(HashMap.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }


    // better approach will be using bits, but I don't like that approach so instead of that, I will use, sorting and pointer approach
    public int singleNumber1(int[] arr) {
        // first sort the array
        Arrays.sort(arr);
        // now start from first index and move by 3 places each time
        for(int i = 1; i < arr.length; i+=3){ // move by 3 places
            if(arr[i] != arr[i - 1]){ // check with previous element
                return arr[i - 1];
            }
        }
        return arr[arr.length - 1];
    }

    // this is the most optimal solution
    public int singleNumberOptimal(int[] arr) {
        // this will be the most optimal solution
        // here we will use the bitwise operators
        int ones = 0; // take ones variable to store number which appears only ones
        int twos = 0; // take twos variable to store number which appears only two times, and three times we don't need that
        for(int i = 0; i < arr.length; i++){
            ones = ones ^ arr[i] & ~(twos); // hey, ones, only add to you, when you are not in twos.
            twos = twos ^ arr[i] & ~(ones); // hey, twos, only add to you, when you are not in ones.
        }
        // return ones
        return ones;
    }
}
