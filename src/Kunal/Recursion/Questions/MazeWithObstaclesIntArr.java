package Kunal.Recursion.Questions;

import java.util.Arrays;

public class MazeWithObstaclesIntArr{
    public static void main(String[] args){
        int[][] arr = {
            {0, 0, 0},
            {0, 0, 0}, 
            {0, 0, 0} 
        };

        int ans = printPathCount(arr, 0, 0, 1);
    }


    static int printPathCount(int[][] arr, int row, int col, int count){
        if(row == arr.length - 1 && col == arr[0].length - 1){
            System.out.println(count);
            arr[row][col] = count;
            for(int[] part: arr){
                System.out.println(Arrays.toString(part));
            }
            System.out.println("");
            return count;
        }

        if(arr[row][col] != 0){
            return count;
        }
        
        arr[row][col] = count;

        if(row < arr.length - 1){
            printPathCount(arr, row + 1, col, count + 1);
        }

        if(col < arr[0].length - 1){
            printPathCount(arr, row, col + 1, count + 1);
        }

        if(row > 0){
            printPathCount(arr, row - 1, col, count + 1);
        }

        if(col > 0){
            printPathCount(arr, row, col - 1, count + 1);
        }

        // in the end reverse what u have marked;
        arr[row][col] = 0;
        return count;
    }
}