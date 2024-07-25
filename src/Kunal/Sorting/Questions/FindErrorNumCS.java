
import java.util.Arrays;


class FindErrorNumCS{

    public static void main(String[] args) {
        int[] arr = {8,7,3,5,3,6,1,4};
        int[] ans = findErrorNumbers(arr);
        System.err.println("The missing and repeating number is " + Arrays.toString(ans));
    }

    public static  int[] findErrorNumbers(int[] arr) {
        int i = 0;
        
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr, i, correct);
            }else{
                i++;    
            }
        }

        // now traverse through sorted array and find the element present at the wrong index that will be the repeated number and the index + 1 will be missing number
        for(int j = 0; j < arr.length; j++){
            if(arr[j] != j + 1){
                return new int[]{arr[j], j + 1};
            }
        }
        return new int[]{-1, -1};
    }
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}