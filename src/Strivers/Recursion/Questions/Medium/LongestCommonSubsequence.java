package Strivers.Recursion.Questions.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubsequence {
    // using recursion
    public int longestCommonSubsequence(String text1, String text2) {
        int count = helper(text1, text2, 0, 0);
        return count;
    }

    private int helper(String text1, String text2, int i, int j){
        if(i >= text1.length() || j >= text2.length()){
            return 0;
        }

        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + helper(text1, text2, i + 1, j + 1);
        }else{
            int left = helper(text1, text2, i + 1, j);
            int right = helper(text1, text2, i, j + 1);
            return Math.max(left, right);
        }
    }
}
