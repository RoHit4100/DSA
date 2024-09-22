package Strivers.Strings;

public class RotatedString {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        s += s; // by concatenating the string, string will have every possible rotation
        return s.contains(goal); // check if the goal is sill there or not
    }
}
