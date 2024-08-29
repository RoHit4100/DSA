package Strivers.Recursion.Questions.Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        generate(ans, n, 0, 0, new StringBuilder());
        return ans;
    }

    // for optimization use StringBuilder
    private void generate(List<String> list, int n, int left, int right, StringBuilder p){
        if(p.length() == 2 * n){
            list.add(p.toString());
            return;
        }

        if(left < n){
            p.append("(");
            generate(list, n, left + 1, right, p);
            p.deleteCharAt(p.length() - 1); // delete the recent added parenthesis
        }
        if(right < left){
            p.append(")");
            generate(list, n, left, right + 1, p);
            p.deleteCharAt(p.length() - 1); // delete the recent added parenthesis
        }
    }

    private void generate1(List<String> list, int n, int left, int right, String p){
        if(p.length() == 2 * n){
            list.add(p);
            return;
        }

        // first check for right if it is lesser than the n
        if(left < n){
            // add opening parenthesis
            generate1(list, n, left + 1, right, p + "(");
        }
        if(right < left){ // right parenthesis depends on left parenthesis
            generate1(list, n, left, right + 1, p + ")");
        }
    }
}
