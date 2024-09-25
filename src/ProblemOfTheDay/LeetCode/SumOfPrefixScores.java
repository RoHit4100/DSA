package ProblemOfTheDay.LeetCode;

public class SumOfPrefixScores {
    // this will be the brute force solution
    public int[] sumPrefixScores(String[] words) {
        // brute force solution will be finding the prefix count for each prefix of word
        int[] ans = new int[words.length];

        // traverse for each word
        for(int i = 0; i < words.length; i++){
            int count = 0;
            String word = words[i];
            // now first take the substring from 0, j + 1
            for(int j = 0; j < word.length(); j++){
                // get the substring
                String sub = word.substring(0, j + 1);
                // now traverse for the rest of the words
                for(int k = 0; k < words.length; k++){
                    String s = words[k];
                    if(s.startsWith(sub)) count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}
