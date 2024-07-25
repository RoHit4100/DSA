
import java.util.Arrays;


class InsertionSort{
    public static void main(String[] args) {
        int[] arr = {45,3,5,6,56,343,434,34,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    static void sort(int[] arr){
        // in insertion sort we check whether or not previous element is greater than current element, 
        // if this is the case then swap or else break out of that inner loop,
        // this sorting algorithm is sorting the arr, till i + 1 elements

        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j > 0; j--){
                if(arr[j] < arr[j - 1]){
                    swap(arr, j, j - 1);
                }else{
                    break;
                }
            }
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}