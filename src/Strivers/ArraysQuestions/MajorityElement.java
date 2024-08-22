package Strivers.ArraysQuestions;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    // now time for optimal approach
    // this is moore's voting algorithm which has time complexity of O(2n) and constant space complexity
    static int majorityElementOptimized(int[] arr){

        int element = 0;
        int count = 0;
        // now traverse through whole by following moor's algorithm
        for(int num: arr){
            // if count is zero our element will the current number
            if(count == 0){
                count = 1;
                element = num;
            }else if(num == element){
                // increase when number is equal to current element
                count++;
            }else{
                // decrease count when num is not equal to current number
                count--;
            }
        }

        // now travers through whole array with element, and get the count, if majority element is not the element we have discovered
        // there is no majority element
        int c = 0;
        for(int num: arr){
            if (num == element){
                c++;
            }
        }

        // at the end the check if its majority element or not
        if(c > (arr.length / 2)){
            return element;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,3,3,3,3,3,3,1,2,2};
        System.out.println(majorityElementOptimized(arr));
        System.out.println(majorityElementHashing(arr));
    }

    // here we will have 3 approaches to solve this problem, first is brute force

    // brute force with O(n2)
    static int majorityElement(int[] arr){
        int count = 0; // this will count the total number of occurrence in the array for each element in the full array
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count > arr.length){
                return arr[i];
            }
        }
        return -1;
    }

    // better approach using hashing

    // better with O(n) and space complexity of O(n)
    static int majorityElementHashing(int[] arr){
        Map<Integer, Integer> freq = new HashMap<>();

        // now traverse through whole array and increase the freq if they found more than one time
        for(int num: arr){
            int frequency = freq.getOrDefault(num, 0);
            freq.put(num, frequency + 1);
        }

        // now traverse through frequency map
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            if(entry.getValue() > arr.length / 2){
                return entry.getKey();
            }
        }

        return -1;
    }
}
