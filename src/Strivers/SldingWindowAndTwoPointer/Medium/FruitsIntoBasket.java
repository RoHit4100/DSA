package Strivers.SldingWindowAndTwoPointer.Medium;
import java.util.*;

public class FruitsIntoBasket {
    // better solution
    public int totalFruitBetter(int[] fruits) {
        // sliding window approach
        int left = 0, right = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(right < fruits.length){
            // insert the current fruits into the map
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1); // update the freq if already exist
            if(map.size() > 2){ // in this case decrease the freq of element, till it becomes zero and thereafter remove that element from map
                while(map.size() > 2 && left < right){
                    // reduce the freq of element present at the left index
                    int f = map.get(fruits[left]);
                    f--;
                    if(f == 0){ // remove that element from the map, only if the frequency becomes zero
                        map.remove(fruits[left]);
                    }else{
                        map.put(fruits[left], f); // or else update the freq
                    }
                    left++; // move left
                }
            }

            if(map.size() <= 2){ // calculate the max length only if the size is less than 2
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++; // move right at any cost
        }

        return maxLength;
    }

    // brute force solution
    public int totalFruit(int[] fruits) {
        // brute force solution will be generating all the subset
        int maxLength = 0;
        // generate all the sub arrays
        for(int i = 0; i < fruits.length; i++){
            Set<Integer> set = new HashSet<>(); // declare set for each subset
            for(int j = i; j < fruits.length; j++){
                set.add(fruits[j]); // add the current element into the set, and then check if adding the current element makes the current subset invalid
                if(set.size() <= 2){
                    maxLength = Math.max(maxLength, j - i + 1); // find the length of the subset
                }else{
                    break;
                }
            }
        }

        return maxLength;
    }
}
