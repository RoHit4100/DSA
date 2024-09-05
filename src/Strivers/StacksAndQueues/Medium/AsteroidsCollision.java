package Strivers.StacksAndQueues.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsteroidsCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        List<Integer> stack = new ArrayList<>();

        for(int i = 0; i < asteroids.length; i++) {
            if(asteroids[i] > 0) { // for positive, means moving in the right direction
                stack.add(asteroids[i]);
            } else if(asteroids[i] < 0) { // for negative, means moving in the opposite direction
                // remove all the asteroids which are smaller than the abs value of the current asteroid
                int top =stack.get(stack.size() - 1);
                while(!stack.isEmpty() && top > 0 && top < Math.abs(asteroids[i])) {
                    stack.remove(stack.size() - 1);
                }
                // check if stack is empty or the last asteroid is moving in the same direction (negative)
                if(stack.isEmpty() || top < 0) {
                    stack.add(asteroids[i]);
                } else if(Math.abs(asteroids[i]) == top) {
                    // if both asteroids are equal in size, both are destroyed
                    stack.remove(stack.size() - 1);
                }
            }
        }

        // Convert the list to an array
        int[] ans = new int[stack.size()];
        for(int i = 0; i < stack.size(); i++) {
            ans[i] = stack.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5,10,-5};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }
}
