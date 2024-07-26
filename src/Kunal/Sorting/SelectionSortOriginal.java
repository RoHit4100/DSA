
import java.util.Arrays;

class SelectionSortOriginal {
    public static void main(String[] args) {
        int[] arr = {45,3,5,6,56,343,434,34,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){

            int lastIndex = arr.length - i - 1;
            int maxElement = findMax(arr, 0, lastIndex);
            swap(arr, lastIndex, maxElement);
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int findMax(int[] arr, int start, int end){
        int max = start;
        for(int i = start + 1; i <= end; i++){
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }
}