package Kunal.Hash;

import java.util.Arrays;

public class SQRTDecomposition {
    // this algorithm is used to find answer of any query in the particular range
    // and time complexity for this algorithm is sqrt(n) which is efficient as compare to linear search complexity


    public static void main(String[] args) {
        int[] arr = {31,41,53,4,6,7,68,42,38,5,34};

        // first find the sqrt of the size of the array

        int n = arr.length;
        int sqrt = (int) Math.sqrt(n);

        // now create new array of size of sqrt + 1
        // this array will take care of the extra element e.g. if array size is 10 then sqrt will be 3, so to store 1 extra element
        // present in the array we need on more block
        int[] blocks = new int[sqrt + 1];


        // now sum of sqrt elements in each block
        // consider initial index of a block as -1;
        int blockIndex = -1;

        // now traverse through the array, to store sum of each block
        for(int i = 0; i < n; i++){
            // we'll check whether the current index is divisible by sqrt, because we have to insert sum of sqrt elements
            // in each block
            if(i % sqrt == 0){
                // increase index size of block
                blockIndex++;
            }
            // add each number in that block
            blocks[blockIndex] += arr[i];
        }

        System.out.println(Arrays.toString(blocks));

        // now we have to find answer with query

        int ans = getTheSumOfRange(arr, blocks, 2, 7, sqrt);

    }

    static int getTheSumOfRange(int[] arr, int[] blocks, int start, int end, int sqrt){
        if(start == end){
            return arr[start];
        }

        // now we have to check in start, middle and end
        // start will find the sum till the point where index gets fully divided by the sqrt
        int answer = 0;

        // for checking in the left part of the array
        // here we will check 3 conditions
        //      1. run this loop until the start index is divisible by the sqrt
        //      2. start < end
        //      3. start != 0, if it is 0 then we can start adding answer right that moment
        while (start % sqrt != 0 & start <= end && start != 0){
            answer += arr[start];
            start++;
        }

        // for middle check, now we know that we are at start of then block
//         indexOfBlock = start / sqrt;
        // e.g. 4/3 = 1 which will be the location of that index in blocks
        while (start + sqrt <= end){
            answer += blocks[start/sqrt];
            // increase int index of blocks by sqrt
            start += sqrt;
        }

        // now the check in the last part of the array
        while (start <= end){
            answer += arr[start];
            start++;
        }

        return answer;
    }

    // now to update into blocks after updating in the actual array
    static void update(int[] arr, int[] blocks, int index, int value, int sqrt){
        int blockId = index / sqrt;

        // if we update the element in the actual array then we have to update in the blocks as well
        // so get we will add the different between new and old value into the block
        blocks[blockId] = blocks[blockId] + (value - arr[index]);
        arr[index] = value;
    }
}
