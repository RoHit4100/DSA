package Strivers.BinarySearchQuestions.BSOn2D;

public class PeakElementIn2DMatrix {
    // optimal approach will be using BS
    public int[] findPeakOptimized(int[][] mat){
        int start = 0;
        int end = mat[0].length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2; // this will be our col
            int max = Integer.MIN_VALUE;
            int maxRow = 0;
            // now go through whole mid and find the max element
            for(int row = 0; row < mat.length; row++){
                if(max < mat[row][mid]){
                    max = mat[row][mid];
                    maxRow = row;
                }
            }

            // now check int the left and right of the max element
            int left = mid > 0 ? mat[maxRow][mid - 1] : -1;
            int right = mid < mat[0].length - 1 ? mat[maxRow][mid + 1] : -1;

            if(left < max && right < max){
                return new int[]{maxRow, mid};
            }else if(mid > 0 && mat[maxRow][mid - 1] > max){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }


    // brute force approach will be finding the max element of the matrix
    public int[] findPeakGrid(int[][] mat) {
        int maxRow = -1;
        int maxCol = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(max < mat[i][j]){
                    max = mat[i][j];
                    maxCol = j;
                    maxRow = i;
                }
            }
        }

        return new int[]{maxRow, maxCol};
    }
}
