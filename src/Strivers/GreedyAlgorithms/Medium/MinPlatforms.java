package Strivers.GreedyAlgorithms.Medium;

import java.util.Arrays;
import java.util.Map;

public class MinPlatforms {
    static int findPlatform(int[] arr, int[] dep) {
        // add your code here
        int platforms = 0;
        // to solve this problem we will sort both of the arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // now take two pointers and start traversing
        // anyhow arrival array will run out times
        // so, we will run loop till that happens
        int maxPlatforms = 0;
        int i = 0, j = 0;
        while (i < arr.length){
            if(arr[i] <= dep[j]){ // if current arrival time is smaller, then increase the station
                platforms++;
                i++; //  now train is arrived, go to next train
            }else{
                platforms--; // if train is leaving reduce the platform
                j++; // go for the next dep time
            }
            maxPlatforms = Math.max(maxPlatforms, platforms); // save the max platforms
        }
        return maxPlatforms;
    }
}
