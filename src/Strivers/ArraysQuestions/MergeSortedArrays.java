package Strivers.ArraysQuestions;

import java.util.Arrays;

public class MergeSortedArrays {
    // type 2
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []arr1, long []arr2){
        // Write your code here.
        int n = arr1.length;
        int m = arr2.length;
        // Declare 2 pointers:
        int left = n - 1;
        int right = 0;

        // Swap the elements until arr1[left] is
        // smaller than arr2[right]:
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        // Sort arr1[] and arr2[] individually:
        Arrays.sort(arr1);
        Arrays.sort(arr2);

    }


    // type 1
    // optimal approach
    public static void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
        // here I will use the two pointer method
        int i = m - 1; // which will be the last index of the nums1
        int j = n - 1; // this will be the last index of the nums2
        int k = m + n - 1; // which will the last index of the nums1;

        // now traverse through array until any of the i or j less than 0
        while(j >= 0){
            if(i >= 0 && nums1[i] > nums2[j]){
                nums1[k] = nums1[i]; // as larger element will be at kth location
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        mergeOptimal(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    // brute force
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // let's go for the first brute force approach

        if(m + n == 1){
            return;
        }

        int[] ans = new int[m + n];

        int i = 0; // for nums1
        int j = 0; // for nums2
        int k = 0; // for ans

        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                ans[k] = nums1[i];
                i++;
            }else{
                ans[k] = nums2[j];
                j++;
            }
            k++;
        }

        // in the end there will be some elements left
        while(i < m){
            ans[k] = nums1[i];
            i++;
            k++;
        }
        while(j < n){
            ans[k] = nums2[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(ans));
        // now add all the elements into nums1
        k = 0;
        i = 0;
        while(i < ans.length){
            nums1[i] = ans[k];
            i++;
            k++;
        }
    }


    // better approach
    public void mergeBetter(int[] nums1, int m, int[] nums2, int n) {
        int i = m; // from this index I will add the elements of nums2
        int j = 0;

        while(i < m + n && j < n){
            nums1[i] = nums2[j];
            i++;
            j++;
        }
        Arrays.sort(nums1);
    }
}

