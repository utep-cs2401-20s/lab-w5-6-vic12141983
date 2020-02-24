public class SnakeGame {
    private boolean [][]game;
    private int [] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame() {

        game = new boolean[1][1];
    }
    public SnakeGame(boolean[][]array,int x, int y){
        for(int i =0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                game[i][j]= array[i][j];
            }
        }
        headPosition = new int[2];
        headPosition[0]=x;
        headPosition[1]=y;


/// check the length of x and y to mark the head.
// check the lengthy of y as well in order to to find position of head
// and verify that the head position is true;


    }
    public int [] lengthCounter(){
        int lengthSnake =0;
        for( int i =0;i<game.length;i++){
            for( int j=0;j<game[i].length;j++){
                if(game[i][j]=true){
                    lengthSnake++;

                }
            }
        }


    }
    public int[] findTailExhaustive(){
        //1. Reset counters to zero
        resetCounters();
        int [] array = new int [3];
        //2. Counter to keep track of checks.

        // Traverse game
        for(int i =0;i<game.length;i++){
            for(int j=0;j<game[i].length;j++){
        //3.Checks if is snake
                if(game[i][j]=true){
        //4. Condition to keep checks within the game
                  if(i-1>=0&&i-1<game.length-1&&j-1>=0&&j-1<game.length-1){
        //5. First check of neighbors
                        if(game[i-1][j]){

                        }
                    }
                }
            }
            // do checks to for head or tail position.
        }
        array[2] = lengthSnake;
        // find location of each next block step by step.
        return array;
    }
    public int nextNeigbor(int x, int y){
        if([x+1]==0){


        }

    }



    public int[] findTailRecursive(){
        // same
     int []arr = new int[2];
    return arr;
    }
    private void resetCounters(){
        exhaustiveChecks =0;
        recursiveChecks =0;
        // reset both methods to zero.

    }
    private static int getRecursiveChecks(){

        return -1;
    }
    private static int getExhaustiveChecks(){
        return -1;
    }



}
