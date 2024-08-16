package Kunal.Recursion.Questions;

class MazeWithObstacles{
    public static void main(String[] args){
        boolean[][] puzzle = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };

        findPaths("", puzzle, 0, 0);
        System.out.println("");
        allPathWithAllDirections("", puzzle, 0, 0);

    }

    static void findPaths(String p, boolean[][] maze, int row, int col){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(p);
            return;
        }
        // if(!maze[row][col]){
        //   return;
        // }
        // or
        if(row < maze.length  - 1 && maze[row][col]){
            findPaths(p + "down ", maze, row + 1, col);
        }
        if(col < maze[0].length  - 1 && maze[row][col]){
            findPaths(p + "right ", maze, row, col + 1);
        }
    }

    static void allPathWithAllDirections(String p, boolean[][] maze, int row, int col){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        // now make check whether the current location is visited or has obstacle.
        if(!maze[row][col]){
            return;
        }

        // now make the current location false, to mark as visited, to not go into infinite loop of recursion calls.
        maze[row][col] = false;

        if(row < maze.length - 1){
            allPathWithAllDirections(p + "down ", maze, row + 1, col);
        }

        if(col < maze[0].length - 1){
            allPathWithAllDirections(p + "right ", maze, row, col + 1);
        }

        if(row > 0){
            allPathWithAllDirections(p + "up ", maze, row - 1, col);
        }

        if(col > 0){
            allPathWithAllDirections(p + "left ", maze, row, col - 1);
        }

        // now revert the changes which are made to before that call, this is known as backtracking
        maze[row][col] = true;
    }
}