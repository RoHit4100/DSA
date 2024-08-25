package Strivers.BinarySearchQuestions.BSOnNumbers;

import java.util.ArrayList;

public class MedianOfTwoSortedArray {
    // better approach will be not using the space for storing the merged sorted array instead we can just play with pointers
    public double findMedianSortedArraysBetter(int[] a, int[] b){
        // Size of two given arrays
        int n1 = a.length;
        int n2 = b.length;

        int n = n1 + n2; //total size
        //required indices:
        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int cnt = 0;
        int ind1el = -1, ind2el = -1;

        //apply the merge step:
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (cnt == ind1) ind1el = a[i];
                if (cnt == ind2) ind2el = a[i];
                i++;
            } else {
                if (cnt == ind1) ind1el = b[j];
                if (cnt == ind2) ind2el = b[j];
                j++;
            }
            cnt++;
        }

        //copy the left-out elements:
        while (i < n1) {
            if (cnt == ind1) ind1el = a[i];
            if (cnt == ind2) ind2el = a[i];
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == ind1) ind1el = b[j];
            if (cnt == ind2) ind2el = b[j];
            cnt++;
            j++;
        }

        //Find the median:
        if (n % 2 == 1) {
            return (double)ind2el;
        }
        return (double)((double)(ind1el + ind2el)) / 2.0;
    }


    // brute force approach will be adding all the element from the both of the array into ArrayList and then returning the median
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < m){
            if(nums1[i] < nums2[j]){
                list.add(nums1[i++]);
            }else{
                list.add(nums2[j]);
                j++;
            }
        }

        while (i < n){
            list.add(nums1[i]);
            i++;
        }

        while (j < m){
            list.add(nums2[j]);
            j++;
        }

        // now get the size of the list
        int size = list.size();
        int mid = size / 2;
        if(size % 2 == 1){
            return (double) list.get(mid);
        }
        return (double)(list.get(mid) + list.get(mid - 1)) / 2;
    }
}
