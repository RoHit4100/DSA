package Strivers.Revision;

public class StarPattern {
    static void pattern9(int n){
        for(int i = 0; i < 2 * n; i++){
            // now I have to print stars in increasing order
            int cols = i > n ? 2 * n - i : i;
            for(int j = 0; j < cols; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern10(int n){
        int num = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(num + " ");
                num = num == 1 ? 0:1;
            }
            System.out.println();
        }
    }

    static void pattern11(int n){
        for(int i = 1; i <= n; i++){
            // number
            for(int num = 1; num <= i; num++){
                System.out.print(num + " ");
            }

            // spaces
            for(int spaces = 0; spaces < (2 * n) -  (2 * i); spaces++){
                System.out.print("  ");
            }

            // number in reverse
            for(int num = i; num >= 1; num--){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static void pattern12(int n){
        int num = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    static void pattern13(int n){
        for(int i = 0; i < n; i++){
            for(int ch = 0; ch <= i; ch++){
                System.out.print((char)(ch + 'A') + " ");
            }
            System.out.println();
        }
    }

    static void pattern14(int n){
        char character = 'A';
        for(int i = 0; i < n; i++){
            for(int ch = 0; ch <= i; ch++){
                System.out.print(character + " ");
            }
            character++;
            System.out.println();
        }
    }

    static void pattern15(int n){
        for(int i = 0; i < n; i++){
            for(int ch = 0; ch < n - i; ch++){
                System.out.print((char)(ch + 'A') + " ");
            }
            System.out.println();
        }
    }

    static void pattern16(int n){
        for(int i = 0; i < n; i++){
            // for spaces
            for(int spaces = 0; spaces < n - i; spaces++){
                System.out.print("  ");
            }

            // for character
            for(char ch = 'A'; ch < 'A' + i; ch++){
                System.out.print(ch + " ");
            }
            for(int ch ='A' + i; ch >= 'A'; ch--){
                System.out.print((char)ch + " ");
            }
            System.out.println();
        }
    }

    static void pattern17(int n){
        n = n % 26;
        // first get the character which has the index n
        char ch = (char) ('A' + n);
        // print the number of rows given to you
        for(int i = 0; i < n; i++){
            // print till i
            for(char j = 0; j <= i; j++){
                // now this the tricky part, start from the index of the character which is n, and increment that with j
                System.out.print((char)(ch - i + j - 1) + " ");
            }
            System.out.println();
        }
    }

    static void pattern18(int n){
        for(int i = 0; i < 2 * n; i++){
            int stars;
            int space;

            // Corrected the if condition and space, stars calculation
            if(i < n){
                stars = n - i;
                space = 2 * i;
            } else {
                stars = i - n + 1;
                space = 2 * (2 * n - i - 1);
            }

            // Loop to print stars
            for(int j = 0; j < stars; j++){
                System.out.print("* ");
            }

            // Loop to print spaces
            for(int spaces = 0; spaces < space; spaces++){
                System.out.print("  ");
            }

            // Loop to print stars again
            for(int j = 0; j < stars; j++){
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    static void pattern19(int n){
        for(int i = 0; i < 2 * n; i++){
            // stars
            int stars, spaces;
            stars = i;
            if(i > n){
                stars = 2 * n - i;
            }
            for(int j = 0; j < stars; j++){
                System.out.print("* ");
            }
            // spaces
            spaces = 2 * n - 2 * stars;
            for(int space = 0; space < spaces; space++){
                System.out.print("  ");
            }
            // stars
            for(int j = 0; j < stars; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern20(int n){
        // print square
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || i == n - 1 || j == 0 || j == n - 1){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void pattern21(int n){
        for(int i = 0; i < 2 * n - 1; i++){
            for(int j = 0; j < 2 * n - 1; j++){
                int top = i;
                int bottom = (2 * n - 2) - i;
                int left = j;
                int right = (2 * n - 2) - j;
                int value = Math.min(Math.min(top, right), Math.min(bottom, left));
                System.out.print(n - value + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        pattern21(5);
    }

    static void pattern1(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern6(int n){
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= n - i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern7(int n){
        for(int i = 0; i < n; i++){
            // for spaces
            for(int spaces = 0; spaces < n - i; spaces++){
                System.out.print("  ");
            }
            // for stars
            for(int j = 0; j < 2 * i + 1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern8(int n){
        for(int i = 0; i < n; i++){
            // for spaces
            for(int spaces = 0; spaces < i; spaces++){
                System.out.print("  ");
            }
            // for stars
            for(int j = 0; j < 2 * n - 2 * i - 1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
