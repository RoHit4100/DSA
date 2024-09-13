package ProblemOfTheDay.LeetCode;

public class XORQueriesOfSubArrays {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // create array which will store the prefix xor
        int[] xor = new int[arr.length];
        xor[0] = arr[0]; // this will help to get the xor of the previous index
        for(int i = 1; i < arr.length; i++){
            xor[i] = xor[i - 1] ^ arr[i]; // find the xor, for current index present in the array with xor present in the xor array
        }

        // now traverse through queries, and store answer in ans array
        int[] ans = new int[queries.length];
        int index = 0;
        for(int[] query: queries){
            // first get the left and right
            int left = query[0];
            int right = query[1];

            if(left == 0){ // if left is zero, then return whatever present in the right index in the xor
                ans[index] = xor[right];
            }else{ // else, get the previous xor of the left, and xor with xor of right
                ans[index] = xor[left - 1] ^ xor[right];
            }
            index++; // increase the index
        }

        // return ans
        return ans;
    }
}
