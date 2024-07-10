package Kunal.Searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {3, 54,33, 4, 2, 1};
        System.out.println(search(arr, 2));
        System.out.println(searchWithForEachLoop(arr, 2));
    }

    static int search(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    static int searchWithForEachLoop(int[] arr, int target){
        int index = 0;
        for(int i: arr){
            if(i == target){
                return index;
            }
            index++;
        }
        return -1;
    }
}
