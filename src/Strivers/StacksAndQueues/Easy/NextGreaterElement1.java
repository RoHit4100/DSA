package Strivers.StacksAndQueues.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {
    // first find the next greater element for the single array
    // this will be the brute force approach
    static int[] nextGreaterElementBF(int[] arr){
        // for each element find the next greater element
        int[] nge = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            int max = arr[i];
            for(int j = i + 1; j < arr.length; j++){
                if(max < arr[j]){
                    max = arr[j]; // if next greater element is found then just break out of the loop
                    break;
                }
            }
            if(arr[i] == max){
                max = -1;
            }
            nge[i] = max;
        }
        return nge;
    }


    // optimized approach will be using monotonic stack, which means we store the element in some order, like increasing or decreasing
    static int[] nextGreaterElementOptimized(int[] arr){
        // for this we will start searching from the end of the array
        int[] nge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--){
            if(stack.isEmpty()){ // check if stack is empty or not, if empty then next greater element will be -1
                nge[i] = -1;
            }else if(arr[i] < stack.peek()){ // check if current element is smaller than the top element of the stack
                nge[i] = stack.peek(); // if smaller, then greater element will be present at the top of the stack
            }else if(arr[i] > stack.peek()){ // if current element is greater than the top, means stack may contain the next greater element of that element
                // pop items until greater element is found
                while(!stack.isEmpty() && arr[i] >= stack.peek()){ // now remove element till you find the next greater element than the current element
                    stack.pop();
                }
                if(stack.isEmpty()){ // now check if stack is empty or not
                    nge[i] = -1; // if empty then there is not greater element than the current element
                }else { // if not then the top of the stack is the greatest element of the current element
                    nge[i] = stack.peek();
                }
            }
            // insert the current element before each iteration
            stack.push(arr[i]);
        }

        return nge;
    }
    static int[] nextGreaterElementOptimizedCleanCode(int[] arr){
        // for this we will start searching from the end of the array
        int[] nge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && arr[i] >= stack.peek()){ // this loop will only trigger when the current element is greater than the peek
                stack.pop(); // pop all the items
            }
            if(stack.isEmpty()){ // check if stack is empty or not
                nge[i] = -1;
            }else{
                nge[i] = stack.peek(); // if not nge will the top of the stack
            }
            // insert the current element before each iteration
            stack.push(arr[i]);
        }

        return nge;
    }

    // next greater element for the two array
    public int[] nextGreaterElement(int[] first, int[] second) {
        // brute force approach will be using hashmap to store index of the second arrays item, with values
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] nge = new int[first.length];
        // first traverse through the second
        for(int i = 0; i < second.length; i++){
            map.put(second[i], i);
        }

        // now traverse through the first array to find the next greatest element
        for(int i = 0; i < first.length; i++){
            if(map.containsKey(first[i])){
                int start = map.get(first[i]);
                int max = first[i];
                for(int j = start + 1; j < second.length; j++){
                    if(max < second[j]){
                        max = second[j];
                        break;
                    }
                }
                if(max == first[i]){
                    nge[i] = -1;
                }else{
                    nge[i] = max;
                }
            }
        }

        return nge;
    }
    public static void main(String[] args) {
        int[] arr = {4,12,5,3,1,2,5,3,1,2,4,6};
        int[] ans = nextGreaterElementBF(arr);
        System.out.println(Arrays.toString(ans));
        int[] a = nextGreaterElementOptimized(arr);
        System.out.println(Arrays.toString(a));
    }
}
