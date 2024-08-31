package ProblemOfTheDay;

public class CheckBinaryStringFrom1toN {
    // brute force
    public boolean queryString(String s, int n) {
        // we have to check for each and every number from 1, n
        for(int i = 1; i <= n; i++){
            String binary = Integer.toBinaryString(i);
            if(!s.contains(binary)){
                return false;
            }
        }
        return true;
    }
}
