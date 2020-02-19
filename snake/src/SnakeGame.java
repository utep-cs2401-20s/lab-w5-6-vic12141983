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
    public int[] findTailExhaustive(){
        // temp array to keep error message from code
        int [] array = {1,2};
        int checks = 0;
        for(int i =0;i<game.length;i++){
            for(int j=0;j<game[i].length;j++){
                if(game[i][j]=true){
                    checks++;
                }
            }
        }
        // find location of each next block step by step.
        return array;
    }
    public int[] findTailRecursive(){
        // same
     int []arr = new int[2];
    return arr;
    }
    private void resetCounters(){
        // reset both methods to zero.

    }
    private static int getRecursiveChecks(){

        return -1;
    }
    private static int getExhaustiveChecks(){
        return -1;
    }



}
