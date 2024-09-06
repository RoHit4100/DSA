package Strivers.StacksAndQueues.Medium;

public class CelebrityProblem {
    // optimal solution will not use the array to store how many peoples know me or I know them
    public int celebrityOptimal(int[][] mat){
        // to use this method we will start from first row and last row, and check if any of the row has 1 or not
        // if any row consist the 1, that means that person cannot be celebrity for sure, because of the defination of the celbrity

        // so find the rows which have the 1 in it
        // and leave that row from search space
        // take two pointer first row and last row
        int start = 0;
        int end = mat.length - 1;

        while(start < end){ // this loop will give the potential celebrity row
            if(mat[start][end] == 1) start++; // if this case hits, means start cannot be celebrity
            else if(mat[end][start] == 1) end--; // if this hits then end cannot be celebrity
            else { // if none of them is equal to 0 that means, there cant be two celebrity
                end--; // so move both of them
                start++;
            }
        }

        // after this loop if start > end, then there will be no celbrity
        if(start > end){
            return -1;
        }

        // after this loop we will be at the potential celebrity row, check that row now, all the cols has to be 0
        // and all the rows has to consist of 1;


        // first check for the cols
        for(int i = 0; i < mat.length; i++){
            if(i == start) continue;
            if(mat[start][i] != 0 || mat[i][start] != 1){
                return -1;
            }
        }

        return start;
    }







    // Function to find if there is a celebrity in the party or not.
    // this will be the brute force solution for this problem
    public int celebrity(int mat[][]) {
        // there will n - 1 person knowing the celebrity, and there will be one celebrity who will not know anyone
        // code here
        // lets just create two array to keep track of who knows whom
        int n = mat.length;
        int m = mat[0].length;
        int[] iKNow = new int[n]; // this array will keep track of which indexes knows which index
        int[] knowMe = new int[m]; // this index will keep track of, whom this current index knows

        // first traverse matrix for find this out
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1){
                    iKNow[j]++;
                    knowMe[i]++;
                }
            }
        }


        // now I Have count ready to cross, check who is celebrity
        // if there is celebrity then he will not know anyone, and every one will no him
        for(int i = 0; i < iKNow.length; i++){
            if(iKNow[i] == 0 && knowMe[i] == n -1 )  return i;// then check if every one know him, means n - 1 peoples,
        }

        return -1;
    }
}
