package Strivers.BinarySearchQuestions.Medium;

import java.util.ArrayList;

public class SingleElementInSortedArray {
    // now it is time for the most optimal approach which is using the BS
    static int findSingleElementInSortedArray(int[] arr){
        // we will use the indexes of the given array to find the ans
        // first we have to reduce the edge conditions
        int n = arr.length;

        if(n == 1){
            return arr[0];
        }

        // check for the first index
        if (arr[0] != arr[1]){
            return arr[0];
        }else if(arr[n - 1] != arr[n - 2]){
            return arr[n - 1];
        }

        // now search from 1 to n - 1
        int start = 1;
        int end = n - 2;
        while (start <= end){
            int mid = start + (end - start) / 2;

            // now first check if middle is our actual ans, by checking element before and after it
            if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]){
                return arr[mid];
            }// now we have to reduce the search space
            // this case means we are standing in the left half of single element
            if(mid % 2 == 1 && arr[mid] == arr[mid - 1] || mid % 2 == 0 && arr[mid] == arr[mid + 1]){ // means we are at the odd index and my previous element is same as current
                // this means even and odd case
                // here we have to eliminate the left half and search in right
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }



    // for arrayList
    public static int singleNonDuplicate(ArrayList<Integer> arr)
    {
        //    Write your code here.
        int n = arr.size(); // Size of the array.

        // Edge cases:
        if (n == 1)
            return arr.get(0);
        if (!arr.get(0).equals(arr.get(1)))
            return arr.get(0);
        if (!arr.get(n - 1).equals(arr.get(n - 2)))
            return arr.get(n - 1);

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If arr[mid] is the single element:
            if (!arr.get(mid).equals(arr.get(mid + 1)) && !arr.get(mid).equals(arr.get(mid - 1))) {
                return arr.get(mid);
            }

            // We are in the left:
            if ((mid % 2 == 1 && arr.get(mid).equals(arr.get(mid - 1)))
                    || (mid % 2 == 0 && arr.get(mid).equals(arr.get(mid + 1)))) {
                // Eliminate the left half:
                low = mid + 1;
            }
            // We are in the right:
            else {
                // Eliminate the right half:
                high = mid - 1;
            }
        }

        // Dummy return statement:
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,4,5,5};
        System.out.println(findSingleNumBF1(arr));
        System.out.println(findSingleNumBF2(arr));
        System.out.println(findSingleElementInSortedArray(arr));
    }


    // this is brute force approach 1 which is using the xor operator
    static int findSingleNumBF1(int[] arr){
        int xor = 0;
        for(int num: arr){
            xor ^= num;
        }
        return xor;
    }

    // another brute force approach will be checking for the previous element of current index and next element of current index
    // if any one of them is not equal to the current index then just return the element present at the current index
    static int findSingleNumBF2(int[] arr){
        // to eliminate edge cases of out of bound check the first and last index first
        // check the length of the arr
        int n = arr.length;
        if(n == 1){
            return arr[0];
        }
        // check for the first element
        if(arr[0] != arr[1]){
            return arr[0];
        }
        // check for the last element
        if(arr[n - 1] != arr[n - 2]){
            return arr[n - 1];
        }

        // now check for the rest of the array
        for(int i = 1; i < n - 1; i++){
            if(arr[i] != arr[i - 1] && arr[i] != arr[i + 1]){
                return arr[i];
            }
        }
        return -1;
    }
}
