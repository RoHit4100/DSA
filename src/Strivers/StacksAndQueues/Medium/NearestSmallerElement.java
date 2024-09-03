package Strivers.StacksAndQueues.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {
    // this will be the brute force solution
    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> nse = new ArrayList<>();

        // for each element search next smallest element to its right
        nse.add(-1);
        for(int i = 1; i < A.size(); i++){
            // now search from i - 1 till i becomes zero
            int min = A.get(i);
            for(int j = i - 1; j >= 0; j--){
                if(min > A.get(j)){ // check if ith element is smaller than the current element
                    min = A.get(j); // if smaller update min and break
                    break;
                }
            }
            // check if min is found or not
            if(min == A.get(i)){
                nse.add(-1);
            }else{
                nse.add(min);
            }
        }

        return nse;
    }


    // optimal approach will be using monotonic stack
    public static ArrayList<Integer> prevSmaller1(ArrayList<Integer> arr) {
        // using monotonic stack
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> nse = new ArrayList<>();

        // start from the beginning of the arr
        for (Integer integer : arr) {
            while (!stack.isEmpty() && stack.peek() >= integer) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nse.add(-1);
            } else {
                nse.add(stack.peek());
            }
            stack.push(integer);
        }
        return nse;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4,5,2,10,8));
        System.out.println(prevSmaller(list));
    }
}
