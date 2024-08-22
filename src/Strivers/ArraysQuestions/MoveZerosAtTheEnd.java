package Strivers.ArraysQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZerosAtTheEnd {
    static void moveZeros(int[] arr){
        // in this approach we will just store all the non-zero elements of the array into a temporary array
        // and after that we will just start to push them into the array
        List<Integer> temp = new ArrayList<>();

        for (int num: arr){
            if(num != 0){
                temp.add(num);
            }
        }

//        System.out.println(temp);
        // now add the element in the array till the list size
        int i = 0;
        for(Integer num: temp){
            arr[i] = num;
            i++;
        }

//        System.out.println(Arrays.toString(arr));
        // now replace 0 after the list.size - 1
        for(int index = temp.size(); index < arr.length; index++){
            arr[index] = 0;
        }

        System.out.println(Arrays.toString(arr));
    }


    // this is the optimal solution
    public static void moveZeroes(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        // rather than considering j = 0, we can just find the first 0th index and store as j and then just run loop from
        // j + 1;
        int j = 0; // Pointer for the next non-zero element
        for (int i = 0; i < arr.length; i++) {
            // check if current element is zero or not
            // if not zero then just swap
            if (arr[i] != 0) {
                swap(arr, i, j);
                // and increase j by one, only increase j when u swap
                j++;
            }
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        System.out.println(Arrays.toString(arr));
//        moveZeroes(arr);
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
