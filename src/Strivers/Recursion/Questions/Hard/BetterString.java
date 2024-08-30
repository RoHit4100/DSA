package Strivers.Recursion.Questions.Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BetterString {
    public static String betterString(String str1, String str2) {
        // first here I have to find the count of subsequence of str1, and then str2, the catch is finding the count of distinct subS
        Set<String> set1 = new HashSet<>();
        findDistinctSubS(new StringBuilder(), 0, str1, set1);
        int subSOfS1 = set1.size();

        Set<String> set2 = new HashSet<>();
        findDistinctSubS(new StringBuilder(), 0, str2, set2);
        int subSOfS2 = set2.size();

        if(subSOfS2 > subSOfS1){
            return str2;
        }
        return str1;
    }

    private static void findDistinctSubS(StringBuilder p, int index, String up, Set<String> set){
        if(index >= up.length()){
            set.add(p.toString());
            return;
        }

        char ch = up.charAt(index);
        p.append(ch); // take it
        findDistinctSubS(p, index + 1, up, set);

        p.deleteCharAt(p.length() - 1); // not take it
        findDistinctSubS(p, index + 1, up, set);
    }
}
