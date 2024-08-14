package Strivers.Arrays;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class RemoveDuplicatesFromArr {
    static int removeDuplicates(int[] arr){
        // this is the bruteforce approach where we will use the SET data structure, which only stores the unique element
        Set<Integer> set = new HashSet<>();
        for(int num: arr){
            set.add(num);
        }

        // before returning we can just change the array by inserting elements in there respective index
        System.out.println(set);
        Iterator<Integer> it = set.iterator();
        Object[] setArray = set.toArray();
        System.out.println(Arrays.toString(setArray));
        for (int index = 0; index < set.size(); index++){
            arr[index] = it.next();
        }
        System.out.println(Arrays.toString(arr));
        return set.size();
    }


    // Inorder to optimize this solution we will take two pointers method
    // a pointer for iteration purpose and a pointer which will only move when it has found the next unique element in the array
    static int removeDuplicatesOptimize(int[] arr){
        int index = 0; // setting this as 1 because 1st element of the array will be always unique
        for(int i = 1; i < arr.length; i++){
            if(arr[index] != arr[i]){
                // swap the index with i
                arr[index + 1] = arr[i];
                // increase the index by one
                index++;
            }
        }

        return index + 1;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,3,4,4,5};
        System.out.println(Arrays.toString(arr));
        System.out.println(removeDuplicatesOptimize(arr));
        System.out.println(Arrays.toString(arr));
    }
}
