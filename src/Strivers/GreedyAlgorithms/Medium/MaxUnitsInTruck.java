package Strivers.GreedyAlgorithms.Medium;

import java.util.Arrays;

public class MaxUnitsInTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // using greedy approach, first I will sort boxTypes using custom comparator
        // the above comparator will only swap if second element is greater than the first
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0; // this variable will store the answer
        // now we have sorted on the basis of units
        for(int[] pair: boxTypes){ // traverse for each pair in boxTypes
            int boxes = pair[0]; // number of boxes present in that pair
            int unitsPerBox = pair[1]; // units per box

            if(truckSize >= boxes){ // check if truck can store the number of boxes
                truckSize -= boxes; // if yes, then reduce the boxes, means reduce how many boxes you are taking from this pair
                totalUnits += boxes * unitsPerBox; // add the units into the total units
            }else{ // this case means truck size is smaller than the current pair boxes
                totalUnits += truckSize * unitsPerBox; // store the units into total units
                break; // break, as we know we have full the truck
            }
        }

        return totalUnits; // return the total units
    }
}
