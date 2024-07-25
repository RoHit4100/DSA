class Pattern{
    public static void main(String[] args) {
        int n = 3;
        patternTriangle(n, 0);
        reverseTriangle(n, 0);
        System.out.println();
        System.out.println();
        patternSquare(n, n);
    }
    static void patternTriangle(int row, int col){
        if(row == 0){
            return;
        }
        if(row > col){
            System.out.print("* ");
            patternTriangle(row, col + 1);
        }else{
            System.out.println();
            patternTriangle(row - 1, 0);
        }
    }

    static void reverseTriangle(int row, int col){
        if(row == 0){
            return;
        }
        if(row > col){
            reverseTriangle(row, col + 1);
            System.out.print("* ");
        }else{
            reverseTriangle(row - 1, 0);
            System.out.println();
        }
    }

    static void patternSquare(int row, int size){
        if(row == 0){
            return;
        }
        printRow(size);
        System.out.println();
        patternSquare(row - 1, size);
    }

    static void printRow(int row){
        if(row == 0){
            return;
        }
        
        System.out.print("* ");
        printRow(row - 1);
    }
}