
class Maze{
    public static void main(String[] args){
        // in maze problem I have to find all the paths which can lead me to destination, and a movement will be right or down
        System.out.println(countPaths(3,3));
        printPaths("", 3, 3);
        System.out.println("With Diagonal Path");
        printAllPaths("", 3, 3);
        System.out.println("");
        printPathWithInitialIndex("", 0, 0, 3 - 1);
    }


    static int countPaths(int row, int col){
        if(row == 1 || col == 1){
            return 1;
        }
        int count = 0;
        if(row > 1){
            count += countPaths(row - 1, col);
        }
        if(col > 1){
            count += countPaths(row, col - 1);
        }
        return count;
    }

    static void printPaths(String p, int row, int col){
        if(row == 1 && col == 1){
            System.out.println(p);
            return;
        }

        if(row > 1){
            printPaths(p + "D", row - 1, col);
        }
        if(col > 1){
            printPaths(p + "R", row, col - 1);
        }
    }
    
    static void printAllPaths(String p, int row, int col){
        if(row == 1 && col == 1){
            System.out.println(p);
            return;
        }

        if(row > 1){
            printAllPaths(p + "Down", row - 1, col);
        }
        if(col > 1 && row > 1){
            printAllPaths(p + "Diagonal", row - 1, col - 1);
        }
        if(col > 1){
            printAllPaths(p + "Right", row, col - 1);
        }
    }


    // with row and col starting from 0 index
    static void printPathWithInitialIndex(String p, int row, int col, int n){
        if(row == n && col == n){
            System.err.println(p);
            return;
        }

        if(row < n){
            printPathWithInitialIndex(p + "D", row + 1, col, n);
        }
        
        if(col < n){
            printPathWithInitialIndex(p + "R", row, col + 1, n);
        }
    }
}