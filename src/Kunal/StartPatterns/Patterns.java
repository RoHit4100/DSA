class Patterns{
    public static void main(String[] args){
        int n = 5;
        // pattern3(n);
        // pattern4(n);
        pattern5(n);
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
}