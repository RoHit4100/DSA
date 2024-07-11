
import java.util.Arrays;

class MissingNumCS{
    public static void main(String[] args) {
        int[] arr = {3,0,1,2};
        int ans = cyclicSort(arr);
        System.out.println("First missing number is: " + ans);
        System.out.println(Arrays.toString(arr));
    }

    static int cyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i];
            if(arr[i] != arr.length && arr[i] != arr[correct]){
                swap(arr, i, correct);    
            }else{
                i++;
            }
        }

        return missingNum(arr);
    }

    static int missingNum(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int correct = arr[i];
            if(arr[i] == arr.length || arr[i] != arr[correct]){
                return i;
            }
        }
        return arr.length;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}