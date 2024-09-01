package Strivers.Maths.Questions;
import java.util.*;
public class PrintDistinctPrimeFactors {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> primes = new HashSet<>();

        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                while (num % i == 0) {
                    primes.add(i);
                    num /= i;
                }
            }
            if (num > 1) {
                primes.add(num); // If the remaining num is a prime number greater than 1
            }
        }

        return primes.size();
    }
}
