
import java.util.Arrays;


class BubbleSort{
    public static void main(String[] args){
        int[] arr = {3,4,2,5,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    static void sort(int[] arr){
        helper(arr, arr.length - 1, 0);
    }

    static void helper(int[] arr, int row, int col){
        if(row == 0){
            return;
        }

        if(col < row){
            if(arr[col] > arr[col + 1]){
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            helper(arr, row, col + 1);
        }else{
            helper(arr, row - 1, 0);
        }
    }
}