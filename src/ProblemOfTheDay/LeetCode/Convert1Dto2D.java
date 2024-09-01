package ProblemOfTheDay.LeetCode;

public class Convert1Dto2D {
    public int[][] construct2DArray(int[] arr, int m, int n) {
        if(m * n != arr.length){
            return new int[][]{};
        }
        int[][] ans = new int[m][n];
        int index = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(index < arr.length){
                    ans[i][j] = arr[index];
                    index++;
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}
