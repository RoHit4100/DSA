class Patterns{
    public static void main(String[] args){
        int n = 5;
        // pattern3(n);
        // pattern4(n);
        pattern8(n);
    }

    static void pattern1(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i; j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    static void pattern4(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n){
        for(int i = 1; i < 2 * n; i++){
            int col = 0;
            if(i > n){
                col = 2 * n - i;
            }else{
                col = i;
            }
            for(int j = 1; j <= col; j++){
                System.out.print("* ");
            }
            System.err.println("");
        }
    }

    static void pattern6(int n){
        for(int i = 1; i < 2 * n; i++){
            int col = i > n ? 2 * n - i : i;
            int s = n - col;
            for(int spaces = 0; spaces < s; spaces++){
                System.out.print(" ");
            }
            for(int j = 0; j <= col - 1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern7(int n){
        for(int i = 1; i <= n; i++){
            int spaces = n - i;
            for(int j = 0; j < spaces; j++){
                System.out.print("  ");
            }

            // for numbers now
            int num = i;
            for(int k = 1; k <= 2 * i - 1; k++){
                System.out.print(num + " ");
                if(k >= i){
                    num++;
                }else{
                    --num;
                }
            }
            System.out.println("");
        }
    }

    static void pattern8(int n){
        int original = n;
        n = 2 * n;
        for(int i = 0; i <= n; i++){
            
            for(int j = 0; j <= n; j++){
                int top = i;
                int left = j;
                int right = n - j;
                int bottom = n - i;
                int num = original - (Math.min(Math.min(top, bottom), Math.min(right, left)));
                System.out.print(num + " ");
            }
            System.out.println();

        }
    }
}