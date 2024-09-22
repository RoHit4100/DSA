package Strivers.Strings;

public class ReverseWordsString {
    public String reverseWords(String s) {
        // first split the words by spaces before that trim all the extra spaces
        s = s.trim();
        StringBuilder str = new StringBuilder();
        String[] arr = s.split("\\s+");
        int end = arr.length - 1;

        while(end >= 0){
            str.append(arr[end] + " ");
            end--;
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }
}
