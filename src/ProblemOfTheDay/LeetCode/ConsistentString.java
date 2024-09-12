package ProblemOfTheDay.LeetCode;
import java.util.*;
public class ConsistentString {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < allowed.length(); i++){
            set.add(allowed.charAt(i));
        }
        int count = 0;
        for(String str: words){
            boolean flag = true;
            for(int i = 0; i < str.length(); i++){
                if(!set.contains(str.charAt(i))){
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }

        return count;
    }
}
