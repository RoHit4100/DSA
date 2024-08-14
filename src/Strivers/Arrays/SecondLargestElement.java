package Strivers.Arrays;

public class SecondLargestElement {
    // here the brute force approach will be sorting the array and then comparing the last element from behind to each number
    // and the better approach will be finding max in the first iteration and then comparing that max number to find the
    // second largest

    public static void main(String[] args) {
        int[] arr = {5,6,2,7,4};
//        System.out.println(secondLargest(arr));
//        System.out.println(findSL(arr));
        System.out.println(helper(arr));
    }

    // better apporach
    static int secondLargest(int[] arr){
        int largest = -1;
        for(int num: arr){
            if(largest < num){
                largest = num;
            }
        }
        System.out.println(largest);
        // now we have to find the second one
        int secondLargest = -1;
        for(int num: arr){
            if(num < largest && secondLargest < num){
                secondLargest = num;
            }
        }

        return secondLargest;
    }


    // optimal approach
    static int findSL(int[] arr){
        int secondL = -1;
        int largest = arr[0];

        // now iterate on whole array
        for(int num: arr){
            // we'll check whether my current number is larger than the previous number
            if(num > largest){
                // if so then we'll just swap the second largest with previous largest and update the largest
                secondL = largest;
                largest = num;
            }else if(num < largest && num > secondL){ // this condition will take care of second largest when the current number is smaller
                // than the larger but greater than the second larger
                secondL = num;
            }
        }
        return secondL;
    }


    private static int helper(int[] arr) {
        int secondL = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int secondS = Integer.MAX_VALUE;

        for (int num : arr) {
            // Update largest and second largest
            if (num > largest) {
                secondL = largest;
                largest = num;
            } else if (num > secondL) {
                secondL = num;
            }

            // Update smallest and second smallest
            if (num < smallest) {
                secondS = smallest;
                smallest = num;
            } else if (num < secondS) {
                secondS = num;
            }
        }
//        System.out.println("smallest: " + smallest + " second smallest: " + secondS + " largest: " + largest + " second Largest: " +secondL);
        return (largest * secondL) - (smallest * secondS);
    }
}

