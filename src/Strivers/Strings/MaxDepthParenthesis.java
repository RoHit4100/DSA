package Strivers.Strings;

public class MaxDepthParenthesis {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int count = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                count++;
                maxDepth = Math.max(count, maxDepth);
            }else if(ch == ')'){
                count--;
            }
        }
        return maxDepth;
    }
}
