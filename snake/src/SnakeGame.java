public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame() {

        game = new boolean[1][1];
    }

    public SnakeGame(boolean[][] array, int x, int y) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                game[i][j] = array[i][j];
            }
        }
        headPosition = new int[2];
        headPosition[0] = x;
        headPosition[1] = y;


/// check the length of x and y to mark the head.
// check the lengthy of y as well in order to to find position of head
// and verify that the head position is true;


    }

    // 1,helper method that keeps track of the length of snake.
    public int[] lengthCounter() {
        // 2
        int lengthSnake = 0;
        int[] array = new int[3];
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[i][j] == true) {
                    lengthSnake++;
                    if (game[i - 1][j] || game[i + 1][j]) {
                        lengthSnake++;
                    }
                }
            }
        }
        return array;

    }

    public int[] findTailExhaustive() {
        //1. Reset counters to zero
        resetCounters();
        int length=0;
        int neighbors =0;
        //2. Array size 3 which holds position of tail,exhaustive checks and length of snake.
        int[] array = new int[3];


        //3. Traverse game
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
        //4.Checks if the current position is snake?
        // If position is true do not increment the exhaustiveChecks.
                if (game[i][j] = true) {

                    length++;
        //5. Check if the current position is not head

                        if ((i - 1 > -1) && (j - 1 > -1) && (i + 1 <= game.length - 1) && (j + 1 <= game.length - 1)) {
        //7. check number of neighbors
                            if (game[i - 1][j] || game[i + 1][j]) {
                                neighbors++;

                            }

                            if(game[i][j-1]||game[i][j+1]) {
                                neighbors++;

                            }
                            length+=neighbors;// adds to the length of the snake.
                            if (i != headPosition[0]&&j!=headPosition[1]&& neighbors==1) {
                                array[0] = i;
                                array[1] = j;
                            }

                        }

                }
                else if(game[i][j]= false) {
                    exhaustiveChecks++;
                }
//                }else{
//                    exhaustiveChecks--;
//                }
            }
            // do checks to for head or tail position.
        }

        // find location of each next block step by step.
        array[2]=length;
        return array;
    }


    public int[] findTailRecursive() {
        // same
        int[] arr = new int[2];
        return arr;
    }

    private void resetCounters() {
        exhaustiveChecks = 0;
        recursiveChecks = 0;
        // reset both methods to zero.

    }

    private static int getRecursiveChecks() {

        return -1;
    }

    private static int getExhaustiveChecks() {
        return -1;
    }


}
