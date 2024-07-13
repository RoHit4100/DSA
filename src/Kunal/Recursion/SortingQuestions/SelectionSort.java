import java.util.Arrays;


class SelectionSort{
    public static void main(String[] args){
        int[] arr = {3,4,2,5,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    static void sort(int[] arr){
        helper(arr, arr.length - 1, 0, 0);
    }

    static void helper(int[] arr, int row, int col, int max){
        if(row == 0){
            return;
        }

        if(col <= row){
            if(arr[col] > arr[max]){
                helper(arr, row, col + 1, col);
            }else{
                helper(arr, row, col + 1, max);
            }
        }else{
            int temp = arr[row];
            arr[row] = arr[max];
            arr[max] = temp;
            helper(arr, row - 1, 0, max);
        }
    }
}