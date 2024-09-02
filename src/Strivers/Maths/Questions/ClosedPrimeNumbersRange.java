package Strivers.Maths.Questions;

public class ClosedPrimeNumbersRange {
    public int[] closestPrimes(int left, int right) {
        // Create a boolean array to represent the sieve for prime checking
        boolean[] sieve = new boolean[right + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false; // 0 and 1 are not primes

        // Apply the sieve of Eratosthenes
        for (int i = 2; i * i <= right; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= right; j += i) {
                    sieve[j] = false;
                }
            }
        }

        int first = -1, second = -1;
        int prev = -1;
        int minDiff = Integer.MAX_VALUE;

        // Find the closest prime pair in the range [left, right]
        for (int i = left; i <= right; i++) {
            if (sieve[i]) { // means the current number is prime
                if (prev != -1) { // check if previous is assign yet or not
                    int diff = i - prev; // find the current difference, which will be current - prev
                    if (diff < minDiff) { // check if current difference is less than the minDiff
                        minDiff = diff; // if min, then make that difference as min difference
                        first = prev; // assign first and second
                        second = i;
                    }
                }
                prev = i; // prev will be the last found prime number
            }
        }

        // If no valid pair is found, return [-1, -1]
        if (second == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{first, second};
    }
}
