package ProblemOfTheDay.LeetCode;

public class ChalkReplacer {
    // this will be the brute force approach
    public int chalkReplacer(int[] chalk, int k) {
        // brute force approach
        // run while loop till k becomes 0
        while(k >= 0){
            // traverse for each chalk in chalks
            for(int i = 0; i < chalk.length; i++){
                if(k < chalk[i]){
                    return i;
                }
                k -= chalk[i];
            }
        }
        return 0;
    }


    // optimal approach
    public int chalkReplacerOptimal(int[] chalks, int k) {
        // for this approach we will find how many chalks are needed
        long chalksNeeded = 0;
        for(int chalk: chalks){
            chalksNeeded += chalk;
        }

        // now we have found the chalks, now find the remainder of k with chalksNeeded
        int remainingChalk = (int)((long)k % chalksNeeded);
        // check if remaining chalks are 0, this means chalks are given to each and every student, then return 0
        if(remainingChalk == 0){
            return 0;
        }

        // now traverse for each chalk, i will be the index of student
        for(int i = 0; i < chalks.length; i++){
            // check is remaining chalks are less than the chalks are required by the student
            if(remainingChalk < chalks[i]){
                // if yes then return the current index of the student
                return i;
            }
            // if not then keep giving the chalk from remaining chalks
            remainingChalk -= chalks[i];
        }

        // dummy return
        return 0;
    }
}
