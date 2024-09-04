package Strivers.StacksAndQueues.Medium;

public class NGEToRight {
    public static int[] count_NGEs(int n, int arr[], int queries, int indices[]) {
        int[] ans = new int[queries];
        for(int i = 0; i < queries; i++){
            int q = indices[i];
            int count = 0;
            int max = arr[q];
            for(int j = q + 1; j < arr.length; j++){
                if(max < arr[j]){
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}
