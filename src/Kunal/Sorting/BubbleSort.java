
import java.util.Arrays;

// Bubble sort is stable algorithm

class BubbleSort{
    public static void main(String[] args) {
        int[] arr = {45,3,5,6,56,343,434,34,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            boolean swap = false;
            for(int j = 1; j < arr.length - i; j++){
                if(arr[j] < arr[j - 1]){
                    swap(arr, j, j - 1);
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}