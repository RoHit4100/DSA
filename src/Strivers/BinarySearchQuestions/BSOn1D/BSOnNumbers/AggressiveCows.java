package Strivers.BinarySearchQuestions.BSOn1D.BSOnNumbers;

import java.util.Arrays;

public class AggressiveCows {
    // optimal approach will be using BS
    public static int aggressiveCowsOptimal(int[] stalls, int k) {
        // Write your code here.
        // In this problem I have to place K cows in stalls
        // answer will be maximum distance which will be achieved by placing each cow at min distance
        // first sort the given stalls
        Arrays.sort(stalls);
        // for sorted array min and max will at first and last
        int n = stalls.length;
        int end = stalls[n -1] - stalls[0];
        int start = 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            boolean canWePlace = check(stalls, k, mid);
            if(canWePlace){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return end;
    }


    public static void main(String[] args) {
        int[] arr = {0, 3, 4, 7, 10 ,9};
        System.out.println(aggressiveCows(arr, 4));
    }


    // brute force approach
    public static int aggressiveCows(int []stalls, int k) {
        // Write your code here.
        // In this problem I have to place K cows in stalls
        // answer will be maximum distance which will be achieved by placing each cow at min distance
        // first sort the given stalls
        Arrays.sort(stalls);
        // after sorting the min element will be first and max will be at end
        int maxDistance = stalls[stalls.length - 1] - stalls[0];
        for(int i = 1; i <= maxDistance; i++){
            boolean canPlace = check(stalls, k, i);
            if(!canPlace){
                return i - 1;
            }
        }

        return maxDistance;
    }

    static boolean check(int[] stalls, int k, int maxDistance){
        int lastStall = stalls[0];
        int cows = 1;
        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] - lastStall >= maxDistance){ // this condition means I can place the cow
                cows++;
                lastStall = stalls[i];
                if(cows == k){
                    return true;
                }
            }
        }
        return cows == k;
    }

}
