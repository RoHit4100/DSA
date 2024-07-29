package Kunal.StackAndQueue.Questions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MaxSumPopWithStack {
    public static void main(String[] args) {
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();

        Scanner sc = new Scanner(System.in);
        int n, firstS, secondS, maxSum;
        n = sc.nextInt();
        firstS = sc.nextInt();
        secondS = sc.nextInt();
        maxSum = sc.nextInt();

        for (int i = 0; i < firstS; i++) {
            int number = sc.nextInt();
            first.push(number);
        }
        for (int i = 0; i < secondS; i++) {
            int number = sc.nextInt();
            second.push(number);
        }

//        int sum = 0;
//        int count = 0;
//        while ((!first.isEmpty() || !second.isEmpty()) && sum < maxSum) {
//            if (!first.isEmpty() && sum + first.peek() <= maxSum) {
//                sum += first.pop();
//                count++;
//            } else if (!second.isEmpty() && sum + second.peek() <= maxSum) {
//                sum += second.pop();
//                count++;
//            } else {
//                break;
//            }
//        }
//
//        System.out.println(count);
    }



    static int twoStacksGame(int maxSum, int[] a, int[] b){
        return helper(maxSum, a, b, 0, 0) - 1;
    }

    static int helper(int maxSum, int[] a, int[] b, int sum, int count){
        if(sum > maxSum){
            return count;
        }

        if(a.length == 0 || b.length == 0){
            return count;
        }

        int leftAns = helper(maxSum, Arrays.copyOfRange(a, 1, a.length), b, sum + a[0], count + 1);
        int rightAns = helper(maxSum, a, Arrays.copyOfRange(b, 1, b.length), sum + b[0], count + 1);

        int ans = Math.max(leftAns, rightAns);
        return ans;
    }
}

