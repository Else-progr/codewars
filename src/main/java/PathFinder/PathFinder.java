package PathFinder;

import java.util.Arrays;
import java.util.Objects;


public class PathFinder {

    public  static boolean pathFinder(String maze) {

        String[] lines = maze.split("\n");
        int labSize=0;
        for (String line : lines) {
            labSize += line.length();
        }
        labSize = (int) Math.sqrt(labSize);
        Character[][] labyrinth = new Character[labSize][labSize];

        int stringPosition = 0;
        int row = 0;
        for(int r = 0; r< labSize; r++  ) {
            for (int c = 0; c< labSize; c++) {
                labyrinth[r][c] = (lines[row].charAt(stringPosition));
                stringPosition++;
                if( stringPosition == lines[row].length() ){
                    row++;
                    stringPosition = 0;
                }
            }
        }

        printMaze(labyrinth);

        row=0;
        int col=0;

        return testTargetIsReached(labyrinth, row, col); //, sol);
    }

    private static boolean testNextSign(Character field) {
        return field.equals('.');
    }


    private static boolean testTargetIsReached(Character[][] maze, int row, int col){ //, String[] sol) {

        if( row == maze.length-1 && col == maze.length-1 ){
            return true;
        }else{

            //Test East
            if ( col < maze.length - 1 ) {
                if ( testNextSign(maze[row][col+1]) ) {
                    maze[row][col] = '*';
                    if ( testTargetIsReached(maze, row, col + 1) ){
                            return true;
                    }
                }
            }

            //Test South
            if ( row < maze.length - 1 ) {
                if ( testNextSign(maze[row+1][col]) ) {
                    maze[row][col] = '*';
                    if (testTargetIsReached(maze, row+1, col) ){
                        return true;
                    }
                }
            }

            //Test West
            if ( col > 0 ) {
                if ( testNextSign(maze[row][col-1]) ) {
                        if ( testTargetIsReached(maze, row, col-1) ){ //, sol)) {
                            return true;
                        }
                }
            }

            //Test North
            if ( row > 0 ) {
                if ( testNextSign(maze[row-1][col]) ) {
                    if ( testTargetIsReached(maze, row-1, col) ){ //, sol)) {
                            printMaze(maze);
                            return true;
                    }
                }
            }

        }

        printMaze(maze);

        return false;
    }

    private static void printMaze(Character[][] maze){
        for(int r = 0; r< maze.length; r++  ) {
            for (int c = 0; c< maze.length; c++) {
                System.out.print(maze[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }


    private static void print(String[] sol, int solLength) {

        for ( int k=0; k< solLength; k++)
            System.out.print(sol[k]+" ");
        System.out.println();
    }


//    private static String getFieldNumber(int row, int col) {
//
//        return row+""+col;
//    }


    private static boolean fieldIsSafe(String[] sol, String fieldNumber, int length) {

        for( int k=0; k<length; k++ )
            if(sol[k].equals(fieldNumber)) return false;

        return true;
    }


//    private static Character[][] buildWall(Character[][] maze, int row, int col) {
//
//        maze[row][col] = 'W';
//        return maze;
//    }


    private static int getLength(String[] sol){

        return Arrays.stream(sol).filter(Objects::nonNull).toArray(String[]::new)
                .length;
    }

//    private static int getLengthMaze(Character[] sol){
//
//        return Arrays.stream(sol).filter(Objects::nonNull).toArray(Character[]::new)
//                .length;
//    }

}