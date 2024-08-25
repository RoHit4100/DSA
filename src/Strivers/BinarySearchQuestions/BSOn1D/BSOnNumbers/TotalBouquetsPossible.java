package Strivers.BinarySearchQuestions.BSOn1D.BSOnNumbers;

import java.util.Arrays;

public class TotalBouquetsPossible {
    public static int roseGarden(int[] bloomDay, int k, int m) {
        long val = (long) m * k;
        int n = bloomDay.length; // Size of the array
        if (val > n) return -1;

        // Find the minimum and maximum bloom day in a single pass
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        int start = min;
        int end = max;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (checkBouquets(bloomDay, mid, m, k)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }


    // optimal solution will use the BS
    public int minDaysOptimal(int[] bloomDay, int m, int k){
        if(m * k > bloomDay.length){
            return -1;
        }
        int max = Arrays.stream(bloomDay).max().getAsInt();
        int min = Arrays.stream(bloomDay).min().getAsInt();

        int start = min;
        int end = max;

        while(start <= end){
            int mid = start + (end - start) / 2;

            boolean bouquetsPossible = checkBouquets(bloomDay, mid, m, k);
            if(bouquetsPossible){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return start;
    }

    // this is the brute force solution
    public int minDays(int[] bloomDay, int m, int k) {
        if(m * k > bloomDay.length){
            return -1;
        }
        int max = Arrays.stream(bloomDay).max().getAsInt();
        int min = Arrays.stream(bloomDay).min().getAsInt();

        for(int i = min; i <= max; i++){
            boolean bouquetsPossible = checkBouquets(bloomDay, i, m, k);
            if(bouquetsPossible){
                return i;
            }
        }
        return -1;
    }

    static boolean checkBouquets(int[] bloomDay, int days, int m, int k){
        int totalBouquets= 0;
        int count = 0;


        for(int flower: bloomDay){
            if(flower <= days){
                count++;
            }else{
                if(count >= k){
                    totalBouquets += (count / k);
                }
                count = 0;
            }
        }

        // in the end check for the same;
        totalBouquets += (count / k);
        if(totalBouquets >= m){
            return true;
        }
        return false;
    }
}
