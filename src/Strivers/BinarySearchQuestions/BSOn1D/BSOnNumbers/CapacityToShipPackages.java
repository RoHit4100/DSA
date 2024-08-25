package Strivers.BinarySearchQuestions.BSOn1D.BSOnNumbers;

public class CapacityToShipPackages {
    public int shipWithinDaysOptimal(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int weight: weights){
            max = Math.max(max, weight);
            sum += weight;
        }

        int start = max;
        int end = sum;

        while (start <= end){
            int mid = start + (end -  start) / 2;

            boolean possible = canShip(weights, days, mid);
            if(possible){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return start;
    }

    // brute force approach
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int weight: weights){
            max = Math.max(max, weight);
            sum += weight;
        }

        for(int i = max; i <= sum; i++){
            boolean possible = canShip(weights, days, i);
            if(possible){
                return i;
            }
        }
        return -1;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int totalDays = 1; // We start with the first day
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                totalDays++; // Need an extra day
                currentLoad = 0;
            }
            currentLoad += weight;
        }

        return totalDays <= days;
    }
}
