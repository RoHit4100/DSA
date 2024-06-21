package Strivers;

import java.util.Scanner;

class Main{
    public static void main(String args[]){
        System.out.println("Hello World");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        printPattern22(n);
    }
    static void printPattern2(int n){
        // Their will be n rows and i columns in every row,
        // where i will be from 1 to n
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printPattern3(int n){
        // their will be n rows, and in each row their will be exact
        // 1 to ith number printed
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void printPattern7(int n){
        // their will be exactly n rows, and each row will contain
        // first n - i spaces, then i star, then again n - i spaces
        // and their will be n * 2 - 1 stars

        for(int i = 1; i <= n; i++){
            // first their will be n - i spaces
            for(int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }

            // now i stars will be printed
            for(int k = 1; k <= 2 * i - 1; k++){
                System.out.print("*");
            }

            // // now i stars will be printed
            // for(int k = 1; k <= i - 1; k++){
            //     System.out.print("*");
            // }

            // now again their will be n - i spaces
            for(int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void printPattern8(int n){

        for(int i = 1; i <= n; i++){
            // first their will be i - 1 spaces;
            for(int j = 1; j <= i - 1; j++){
                System.out.print(" ");
            }

            // then their will be 2 * n - i stars printed in each row
            int stars = 2 * n - (2 * i - 1);
            for(int k = 1; k <= stars ; k++){
                System.out.print("*");
            }

            // and at the end their will be same spaces printed as the start
            for(int j = 1; j <= i - 1; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void patternRohit(int n){
        // their will be 2 * n - 1 rows, and in each row their will be
        // 2 * n - 2 * i spaces
        // then 2 * (2 )

        for(int i = 1; i <= 2 * n - 1; i++){
            // first their will be 2 * n - 2 * i spaces
            int spaces = 2 * n - 2 * i;
            if(spaces < 0){
                spaces = -spaces;
            }
            for(int j = 1; j <= spaces / 2; j++){
                System.out.print(" ");
            }


            // their will be 2 * i - 1 stars printed in each row
            int stars = i;
            if(stars > n){
                stars = 2 * n - i;
            }
            for(int k = 1; k <= 2 * stars - 1; k++){
                System.out.print("*");
            }

            // and at the end their will be same spaces printed as the start
            int endSpaces = 2 * n - 2 * i;
            if(endSpaces < 0){
                endSpaces = -endSpaces;
            }
            for(int j = 1; j <= endSpaces / 2; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void printPattern11(int n){
        // Write your code here.
        // their will be n rows, and each row i col will be printed
        // pattern will be like 1 0 1 0 1
        int start = 1;
        for(int i = 1; i <= n; i++){
            if(i % 2 == 0){
                start = 0;
            }else {
                start = 1;
            }
            for(int j = 1; j <= i; j++){
                System.out.print(start);
                start = 1 - start;
            }
            System.out.println();
        }
    }

    static void printPattern12(int n){
        for(int i = 1; i <= n; i++){
            // for print number in increasing order
            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }

            // for printing spaces
            for(int k = 1; k <= 2 * n - 2 * i; k++){
                System.out.print(" ");
            }

            // for printing number in reverse order
            for(int l = i; l >= 1; l--){
                System.out.print(l);
            }
            System.out.println();
        }
    }

    static void printPattern13(int n){
        // char start = 'A';;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print((char)('A' + j)+ " ");
            }
            System.out.println();
        }
    }

    static void printPattern13R(int n){
        for(int i = 0; i < n; i++){
            for(char j = 'A'; j <= 'A' + i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void printPattern14(int n){
        for(int i = 0; i < n; i++){
            // for(char j = 'A'; j <= 'A' + (n - i - 1); j++){
            //     System.out.print(j + " ");
            // }
            for(int j = 0; j <= n - i - 1; j++){
                System.out.print((char)('A' + j) + " ");
            }
            System.out.println();
        }
    }

    static void printPattern17(int n){
        // here spaces character spaces form will be applied, where characters are printed in reverse order
        // after j becomes greater than i

        for(int i = 0; i < n; i++){
            // for printing spaces
            for(int j = 0; j < n - i - 1; j++){
                System.out.print("  ");
            }

            // // for printing characters till i
            // for(int j = 0; j <= i; j++){
            //     System.out.print((char)('A' + j) + " ");
            // }
            // // for printing characters after i in reverse order
            // for(int j = i; j > 0; j--){
            //     System.out.print((char)('A' + j - 1) + " ");
            // }


            // Strivers method
            char ch = 'A';
            int breakPoint = (2 * i + 1) / 2;
            for(int j = 1; j <= 2 * i + 1; j++){
                System.out.print(ch + " ");
                if(j <= breakPoint)
                    ch++;
                else
                    ch--;

            }
            System.out.println();
        }
    }


    static void printPattern19(int n){
        for(int i = 0; i <= n; i++){

            // for printing stars
            for(int j = 0; j < n - i; j++){
                System.out.print("* ");
            }

            // for printing spaces
            for(int j = 0; j < 2 * i ; j++){
                System.out.print("  ");
            }

            // for printing stars
            for(int j = 0; j < n - i; j++){
                System.out.print("* ");
            }
            if(i == n - 1)
                continue;
            System.out.println();
        }

        // from printing in reverse order
        for(int i = n - 1; i >= 0; i--){

            // for printing stars
            for(int j = 0; j < n - i; j++){
                System.out.print("* ");
            }

            // for printing spaces
            for(int j = 0; j < 2 * i ; j++){
                System.out.print("  ");
            }

            // for printing stars
            for(int j = 0; j < n - i; j++){
                System.out.print("* ");
            }

            System.out.println();
        }
    }



    static void printPattern20(int n ){
        // star space starr pattern
        for(int i = 1; i <= n * 2; i++){
            // for printing stars in symmetric order, their will be i stars in each row
            int stars = i;
            if(i > n){
                stars = 2 * n - i;
            }
            for(int j = 1; j <= stars; j++){
                System.out.print("* ");
            }


            // for printing spaces
            int spaces = 2 * n - 2 * stars;
            for(int j = 1; j <= spaces; j++){
                System.out.print("  ");
            }


            // for printing stars in reverse orderz
            for(int j = 1; j <= stars; j++){
                System.out.print("* ");
            }

            System.out.println();
        }
    }



    static void printPattern22(int n){


        for(int i = 0; i < 2 * n - 1; i++){
            for(int j = 0; j < 2 * n - 1; j++){
                int top = i;
                int bottom = 2 * n - i - 2;
                int left = j;
                int right = 2 * n - j - 2;
                int min = Math.min(Math.min(right, left), Math.min(top, bottom));
                System.out.print(n - min + " ");
            }
            System.out.println();
        }
    }
}