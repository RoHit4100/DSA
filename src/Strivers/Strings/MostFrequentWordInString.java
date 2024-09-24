package Strivers.Strings;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentWordInString {
    public String mostFrequentWord(String[] arr,int n){
        // code here
        Map<String, Integer> map = new HashMap<>();
        String ans = null;
        int max = -1;
        for(String s: arr){
            int freq = 0;
            if(map.containsKey(s)){
                freq = map.get(freq);
                freq++;
            }
            if(max < freq){
                max = freq;
                ans = s;
            }
            map.put(s, freq);
        }
        return ans;
    }
}
