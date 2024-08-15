package Strivers.Arrays;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        int n = nums1.length;
        int m = nums2.length;

        // now add all the nums of nums1 into the first set
        for(int num: nums1){
            set.add(num);
        }

        // now iterate on second array
        for(int num: nums2){
            if(set.contains(num)){
                intersection.add(num);
            }
        }

        // create new array to store all the elements of intersections
        int[] ans = new int[intersection.size()];
        int i = 0;
        for(Integer num: intersection){
            ans[i] = num;
            i++;
        }

        return ans;
    }
}
