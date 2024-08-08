package Kunal.Hash.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CountSort {

    public static void countSort(int[] arr){
        // this algorithm is suitable for the small numbers only
        // n + m time complexity
        // first find the max number present in the array
        // then create a frequency array which store the frequency of each element
        // this algorithm basically replaces all the values of original array by the index of any element of the newly created array
        // which have frequency value more than 0.
        // means frequency will be more than 0

        int max = arr[0];
        for(int num: arr){
            if(num > max){
                max = num;
            }
        }

        // now create new frequency array
        int[] freq = new int[max + 1];

        // now count the frequency
        for(int num: arr){
            // e.g. num == 4
            // then freq[4]++
            // 0++
            // which will be 1
            freq[num]++;
        }

        // now replace all the values present in the original array
        // maintain one index pointer which will maintain the index of the original array
        int index = 0;
        for(int i = 0; i <= max; i++){
            // check if in the freq array any ith location has more than 0 value
            // run this while loop till that value becomes 0
            while (freq[i] > 0){

                // now replace the original arrays index location with the index of the newly created array
                arr[index] = i;
                // increment the index pointer of the original array
                index++;
                // decrement the value present at the ith index
                freq[i]--;
            }
        }
    }


    static void countSortUsingHashMap(int[] arr){
        if(arr.length == 0){
            return;
        }
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        for(int i = min; i <= max; i++){
            int count = map.getOrDefault(i, 0);
            for(int j = 0; j < count; j++){
                arr[index] = i;
                index++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,5,2,3,4,5};
//        countSort(arr);
        countSortUsingHashMap(arr);
        System.out.println(Arrays.toString(arr));
    }
}
