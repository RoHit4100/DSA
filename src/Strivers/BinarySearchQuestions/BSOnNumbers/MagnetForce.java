package Strivers.BinarySearchQuestions.BSOnNumbers;

import java.util.Arrays;

public class MagnetForce {
    // optimal approach
    public static int maxDistanceOptimal(int[] position, int k) {
        Arrays.sort(position);
        // after sorting the min element will be first and max will be at end
        int maxDistance = position[position.length - 1] - position[0];
        int end = maxDistance / (k - 1);
        int start = 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            boolean canWePlace = check(position, k, mid);
            if(canWePlace){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return end;
    }

    // brute force approach
    public static int maxDistance(int[] position, int k) {
        Arrays.sort(position);
        // after sorting the min element will be first and max will be at end
        int maxDistance = position[position.length - 1] - position[0];
        maxDistance = maxDistance / (k - 1);
        for(int i = 1; i <= maxDistance; i++){
            boolean canPlace = check(position, k, i);
            if(!canPlace){
                return i - 1;
            }
        }

        return maxDistance;
    }


    static boolean check(int[] position, int k, int maxDistance){
        int lastPosition = position[0];
        int baskets = 1;
        for(int i = 1; i < position.length; i++){
            if(position[i] - lastPosition >= maxDistance){ // this condition means I can place the cow
                baskets++;
                lastPosition = position[i];
                if(baskets == k){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,1000000000};
        System.out.println(maxDistance(arr, 2));
        System.out.println(maxDistanceOptimal(arr, 2));
    }
}
