package Strivers.GreedyAlgorithms.Hard;

public class Candy {
    // optimal solution using slop method
    public int candyOpmal(int[] ratings) {
        // Most optimal solution using slope method
        int n = ratings.length;
        int sum = 1;
        int i = 1;
        while(i < n){
            // first check if the current slop is flat, means the current element will be same as the previous element
            if(ratings[i] == ratings[i - 1]){
                // move i, add one to answer, and continue
                i++;
                sum += 1;
                continue;
            }

            // now go for increasing slope
            int peak = 1;
            while(i < n && ratings[i] > ratings[i - 1]){ // this loop will run till slop is increasing
                peak += 1; // increase peak before adding
                sum += peak; // add into the sum
                i++;
            }

            // now go for decreasing slope
            int down = 1;
            while(i < n && ratings[i] < ratings[i - 1]){
                sum += down;
                down += 1;
                i++;
            }

            // now in the end check if down is greater than the peak or not
            if(down > peak){
                sum += (down - peak);
            }
        }

        return sum;
    }


    // better solution
    public int candyBetter(int[] arr) {
        // in this we will have to array for start to end iteration, and one for end to start iteration
        int n = arr.length;
        int[] left= new int[n];
        left[0] = 1;
        // now iteration for start to end
        int candy = 1;
        for(int i = 1;i < n; i++){
            if(arr[i] > arr[i - 1]){ // greater than neighbour
                left[i] = ++candy;
            }else{
                candy = 1;
                left[i] = candy;
            }
        }

        int total = Math.max(left[n - 1], 1);
        candy = 1;
        for(int i = n - 2; i >= 0; i--){
            if(arr[i] > arr[i + 1]){
                candy++;
            }else {
                candy = 1;
            }
            total += Math.max(candy, left[i]);
        }
        return total;
    }



    // brute force solution
    public int candy(int[] arr) {
        // in this we will have to array for start to end iteration, and one for end to start iteration
        int n = arr.length;
        int[] startToEnd = new int[n];
        int[] endToStart = new int[n];
        startToEnd[0] = 1;
        // now iteration for start to end
        int candy = 1;
        for(int i = 1;i < n; i++){
            if(arr[i] > arr[i - 1]){ // greater than neighbour
                startToEnd[i] = ++candy;
            }else{
                candy = 1;
                startToEnd[i] = candy;
            }
        }

        endToStart[n - 1] = 1;
        candy = 1;
        for(int i = n - 2; i >= 0; i--){
            if(arr[i] > arr[i + 1]){ // greater than neighbour
                endToStart[i] = ++candy;
            }else{
                candy = 1;
                endToStart[i] = candy;
            }
        }

        // now traverse from the array and add the max of both of them into sum
        int total = 0;
        for(int i = 0; i < n; i++){
            int max = Math.max(startToEnd[i], endToStart[i]);
            total += max;
        }
        return total;
    }
}
