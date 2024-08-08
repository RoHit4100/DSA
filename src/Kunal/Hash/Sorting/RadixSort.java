package Kunal.Hash.Sorting;

import java.util.Arrays;

public class RadixSort {
    static void radixSort(int[] arr){
        /*
             this algorithm uses count sort
             in this algorithm first we have to find the max number
             and then perform count sort for the max number of digit
             and in each iteration we will sort the array for every digit, of from unit digit place to max place
         */

        int max = Arrays.stream(arr).max().getAsInt();

        // in this for loop we are starting from the unit place of the number
        // and in each iteration we'll just multiply the i with 10
        // e.g. 1 ==> unit
            //  10 ==> tens digit
            // 100 ==> 100s digit

        // and we are doing this until we found a case were our max number divide by 100 gives value less than 0
        // e.g. 471 / 1000 == 0 && 471 / 100 == 71
//        for(int i = 1; max/i > 0; i *=10){
//
//        }
    }
}
