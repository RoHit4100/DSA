package Strivers.BinarySearchQuestions.BSOnNumbers;

public class KokoEatingBananas {
    // optimal approach will use the BS, as we are working in the range of numbers
    public static int minEatingSpeedBS(int[] piles, int h) {
        int max = max(piles);

        int start = 1;
        int end = max;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int totalHours = getHours(piles, mid);
            if (totalHours <= h) {
                // Try to find a smaller valid speed
                end = mid - 1;
            } else {
                // Increase the speed
                start = mid + 1;
            }
        }

        // Start will now be the minimum valid speed
        return start;
    }


    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        System.out.println(minEatingSpeed(piles, 8));
        System.out.println(minEatingSpeedBS(piles, 8));
    }

    // brute force approach
    // this solution has time complexity of O(n + n2);
    public static int minEatingSpeed(int[] piles, int h) {
        int maxEat = max(piles);

        // now run a for loop till maxEat
        for(int i = 1; i <= maxEat; i++){
            // now get the sum of how many hours will require with the speed every i
            int totalHours = getHours(piles, i);
            if(totalHours <= h){
                return i;
            }
        }
        return -1;
    }

    static int getHours(int[] piles, int speed) {
        double totalHours = 0;
        for (int banana : piles) {
            totalHours += Math.ceil((double) banana / speed);
        }
        return (int) totalHours;
    }

    static int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num: arr){
            max = Math.max(max, num);
        }
        return max;
    }
}
