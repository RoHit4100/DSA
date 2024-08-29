package Strivers.Recursion.Questions.Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinary {
    public static List<String> generateBinaryStrings(int n) {
        // code here
        List<String> ans = new ArrayList<>();
        generate(ans, new StringBuilder(), n, true); // take boolean value to keep track of last inserted value
        return ans;
    }

    private static void generate(List<String> ans, StringBuilder p, int n, boolean one){
        if(p.length() == n){
            ans.add(p.toString());
            return;
        }

        generate(ans, p.append('0'), n, true); // one should be true, as we can insert one into the string
        p.deleteCharAt(p.length() - 1); // remove last added character
        if(one) { // if one is true only then insert one
            generate(ans, p.append('1'), n, false); // turn one as false, to stop consecutive insertions of one
            p.deleteCharAt(p.length() - 1); // remove last character
        }
    }
}
