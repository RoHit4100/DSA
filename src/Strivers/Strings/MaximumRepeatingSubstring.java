package Strivers.Strings;

public class MaximumRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        int sLength = sequence.length(); // get the length of sequence
        int wLength = word.length(); // get the length of the word

        if (wLength > sLength) return 0; // check if word length is greater than the s length

        int ans = 0; // this will contain the count
        String repeatedWord = word; // we will keep track of the word in string

        while (sequence.contains(repeatedWord)) { // check if sequence contains the string or not
            ans++; // if yes then increment the answer
            repeatedWord += word; // add the word into repeating word
        }

        return ans;
    }
}
