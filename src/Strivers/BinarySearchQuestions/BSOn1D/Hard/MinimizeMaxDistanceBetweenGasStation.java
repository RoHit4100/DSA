package Strivers.BinarySearchQuestions.BSOn1D.Hard;

import java.util.Objects;
import java.util.PriorityQueue;

public class MinimizeMaxDistanceBetweenGasStation {
    // better solution will use the priority queue to get the max difference between two stations
    public double minimizeDistanceBetweenStations(int[] arr, int K){
        // Max-heap to store the largest section length with its index
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.sectionLength, a.sectionLength));

        int n = arr.length;
        int[] howMany = new int[n - 1];

        // Initialize the priority queue with the initial sections
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            pq.offer(new Pair(diff, i));
        }

        // Place K stations
        for (int k = 1; k <= K; k++) {
            Pair max = pq.poll(); // Get the section with the maximum length
            assert max != null;
            int sectionIndex = max.indexOfSection;
            howMany[sectionIndex]++;

            // Calculate new section length after placing the station
            double difference = arr[sectionIndex + 1] - arr[sectionIndex];
            double newSectionLength = difference / (howMany[sectionIndex] + 1);

            // Reinsert the updated pair into the priority queue
            pq.offer(new Pair(newSectionLength, sectionIndex));
        }

        // The maximum section length remaining in the priority queue is the answer
        return Objects.requireNonNull(pq.poll()).sectionLength;
    }


    // we will need the pair DS to store the pair of section length and index of that section
    class Pair{
        double sectionLength;
        int indexOfSection;

        Pair(double sectionLength, int indexOfSection){
            this.sectionLength = sectionLength;
            this.indexOfSection = indexOfSection;
        }
    }


    // this is the brute force approach, which takes complexity of k * n + n
    public static double MinimiseMaxDistance(int []arr, int K){
        // Write your code here.
        int n = arr.length;

        int[] howMany = new int[n - 1]; // this array will keep the track of
        // how many are place at that section 

        for(int k = 1; k <= K; k++){
            int maxIndex = getMaxIndex(arr, n, howMany); // this function will return the maxIndex where we should place the station
            // to overall minimized the answer
            howMany[maxIndex]++; // in the end add the station at that section
        }

        // now find the max section
        double ans = 0;
        // now find the ans by finding the max in howMany
        for(int i = 0; i < n - 1; i++){
            double difference = arr[i + 1] - arr[i]; // get the difference
            double sectionLength = difference / (double)(howMany[i] + 1); // find the section length

            ans = Math.max(ans, sectionLength); // answer will the max length of the section
        }

        return ans;
    }

    private static int getMaxIndex(int[] arr, int n, int[] howMany) {
        double maxSection = -1; // this variable will find the max distance between the
        // two station
        // and we can place new station in between that section
        int maxIndex = -1;
        for(int i = 0; i < n - 1; i++){ // un this loop till n-1 as we are comparing with next index
            double difference = arr[i + 1] - arr[i]; // this line will get the difference
            double sectionLength = difference / (double)(howMany[i] + 1); // this line wil get the length of that section

            // now save the max section length, and the index of the section
            if(sectionLength > maxSection){
                maxSection = sectionLength;
                maxIndex = i;
            }
        }
        // return the max index of the section
        return maxIndex;
    }
}
