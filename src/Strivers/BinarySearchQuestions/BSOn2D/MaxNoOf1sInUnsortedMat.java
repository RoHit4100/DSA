package Strivers.BinarySearchQuestions.BSOn2D;

public class MaxNoOf1sInUnsortedMat {

    // brute force approach will be linear search to find the count of the ones in the each row
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxRow = -1;
        int ones = 0;

        for(int i = 0; i < mat.length; i++){
            int count = 0;
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            if(count > ones){
                maxRow = i;
                ones = count;
            }
        }

        return new int[] {maxRow, ones};
    }
}
