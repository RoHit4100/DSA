package Strivers.ArraysQuestions;

public class PascalTriangle {
    // n-1Cr-1 = n! / (r! * (n - r)!)


    // optimized approach
    public static int[][] pascalTriangle(int N) {
        // Initialize a 2D array to store the Pascal's triangle
        int[][] triangle = new int[N][];

        // Loop through each row
        for (int i = 0; i < N; i++) {
            // Initialize the current row with the appropriate length
            triangle[i] = new int[i + 1];

            // Set the first and last element of each row to 1
            triangle[i][0] = 1;
            triangle[i][i] = 1;

            // Fill in the values between the first and last element
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }

        return triangle;
    }

    // Method to print the Pascal's Triangle
    public static void printPascalTriangle(int[][] triangle) {
        for (int[] row : triangle) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    static void printRowOfPascalTriangle(int r){
        int result = 1;
        System.out.print(result + " ");
        for(int i = 1; i < r; i++){
            result = result * (r - i);
            result = result / i;
            System.out.print(result + " ");
        }
    }
    public static void main(String[] args) {
        int n = 6;
        int r = 3;
        System.out.println(findnCr(n - 1, r - 1));
        // for printing entire pascal triangle
        for(int i = 1; i <= n; i++) {
            for (int c = 1; c <= i; c++) {
                // for printing each row in pascal triangle
                System.out.print(findnCr(i - 1, c - 1) + " ");
            }
            System.out.println();
        }

        System.out.println();
        printRowOfPascalTriangle(n);
    }
    // code for the first variant

    static int findnCr(int n, int r){
        // to get the num at that respective index we will use for loop
        int ans = 1;
        for(int i = 0; i < r; i++){
            ans = ans * (n - i);
            ans = ans / (i + 1);
        }
        return ans;
    }
}
