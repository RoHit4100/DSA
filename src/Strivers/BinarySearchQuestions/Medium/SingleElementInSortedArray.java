package Strivers.BinarySearchQuestions.Medium;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,4,5,5};
        System.out.println(findRepeatedNumBF1(arr));
    }


    // this is brute force approach 1 which is using the xor operator
    static int findRepeatedNumBF1(int[] arr){
        int xor = 0;
        for(int num: arr){
            xor ^= num;
        }
        return xor;
    }

    // another brute force approach will be checking for the previous element of current index and next element of current index
    // if any one of them is not equal to the current index then just return the element present at the current index
    static int findRepeatedNumBF2(int[] arr){
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
