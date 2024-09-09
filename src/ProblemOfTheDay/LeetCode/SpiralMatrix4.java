package ProblemOfTheDay.LeetCode;

import Strivers.LinkList.Leetcode;

import java.util.Arrays;

public class SpiralMatrix4 extends Leetcode {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // lets solve this question by using sprial traversal
        int rowStart = 0, rowEnd = m - 1;
        int colStart = 0, colEnd = n - 1;
        int[][] ans = new int[m][n];

        for(int[] row: ans){
            Arrays.fill(row, -1);
        }
        if(head == null) return ans;
        while(head != null){
            // first traverse for the first row, col wise
            for(int i = colStart; i <= colEnd; i++){
                if(head == null) break;
                else{
                    ans[rowStart][i] = head.val;
                    head = head.next;
                }
            }
            rowStart++; // increase the row

            // now traverse for colEnd, row wise
            for(int i = rowStart; i <= rowEnd; i++){
                if(head == null) break;
                else{
                    ans[i][colEnd] = head.val;
                    head = head.next;
                }
            }
            // reduce the colEnd
            colEnd--;

            // now traverse for the last row, col wise
            for(int i = colEnd; i >= colStart; i--){
                if(head == null) break;
                else{
                    ans[rowEnd][i] = head.val;
                    head = head.next;
                }
            }
            // reduce the rowEnd
            rowEnd--;

            // now traverse for first col, row wise
            for(int i = rowEnd; i >= rowStart; i--){
                if(head == null) break;
                else{
                    ans[i][colStart] = head.val;
                    head = head.next;
                }
            }
            // increase the colStart
            colStart++;
        }
        return ans;
    }
}
