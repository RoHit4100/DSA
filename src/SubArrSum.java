import java.util.Arrays;

public class SubArrSum {
    public static void main(String[] args) {
        int[] arr = new int[1];
        System.out.println(Arrays.toString(arr));
//        int[] arr = {25, 11, 12, 21, 25, 11};
//        int[] ans = findMinSum(2, arr);
//        System.out.println(Arrays.toString(ans));

    }

    public static int[] findMinSum(int k, int[] arr){
        int minSum = Integer.MAX_VALUE;
        int[] ans = new int[k];
        for(int i = 0; i < arr.length - k; i++){
            int sum = 0;
            for(int j = i; j < i + k ; j++){
                sum += arr[j];
            }
            if(minSum > sum){
                minSum = sum;
                for(int j = 0; j < k; j++){
                    ans[j] = arr[i + j];
                }
            }
        }
        return ans;
    }
}
