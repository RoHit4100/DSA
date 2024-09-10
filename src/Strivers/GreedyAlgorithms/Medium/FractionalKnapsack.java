package Strivers.GreedyAlgorithms.Medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FractionalKnapsack {
    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    // Function to get the maximum total value in the knapsack.
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item[] arr, int n) {
        // Sort the items by value-to-weight ratio in descending order
        Comparator<Item> byValue = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double r1 = (double) o1.value / o1.weight;
                double r2 = (double) o2.value / o2.weight;

                if (r1 > r2) return -1;  // higher ratio comes first
                if (r1 < r2) return 1;
                return 0;
            }
        };

        Arrays.sort(arr, byValue);
        // now the array is sorted in descending order of value/weight ratio
        double totalValue = 0.0;

        for (Item item : arr) {
            int value = item.value;
            int weight = item.weight;

            if (weight <= W) {
                W -= weight;
                totalValue += value;
            } else {
                // Take the fraction of the remaining weight
                totalValue += value * ((double) W / weight);
                break;  // after taking the fraction, the knapsack is full
            }
        }

        return totalValue;
    }
}
