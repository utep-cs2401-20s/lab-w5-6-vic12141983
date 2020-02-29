public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame(int[][] test, int x, int y) {

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
    public int[] lengthCounter(int[] arr) {
        // 2
        int lengthSnake = 0;
        int[] array = new int[3];
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[i][j]) {
                    lengthSnake++;
                    if (game[i - 1][j] || game[i + 1][j]) {
                        lengthSnake++;
                    }
                    if (game[i][j - 1] || game[i][j + 1]) {
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
        int length = 0;
        int neighbors = 0;
        //2. Array size 3 which holds position of tail,exhaustive checks and length of snake.
        int[] array = new int[3];


        //3. Traverse game
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                //4.Checks if the current position is snake?
                // If position is true do not increment the exhaustiveChecks.
                if (game[i][j]) {

                    length++;
                    //5. Check if the current position is not head
                    //6. Keeps snake within the bounds of the SnakeGame.
                    if ((i - 1 > -1) && (j - 1 > -1) && (i + 1 <= game.length - 1) && (j + 1 <= game.length - 1)) {
                        //7. check number of neighbors
                        if (game[i - 1][j] || game[i + 1][j]) {
                            neighbors++;
                        }

                        if (game[i][j - 1] || game[i][j + 1]) {
                            neighbors++;

                        }
                        //8.Add neighbors to length after checks are complete
                        length += neighbors;// adds to the length of the snake.
                        if (i != headPosition[0] && j != headPosition[1] && neighbors == 1) {
                            //9.Tail Found assign the x and y elements to each index of array.
                            array[0] = i;
                            array[1] = j;
                        }

                    }

                }
                //10. If snake not found increment checks.
                else if (game[i][j] = false) {
                    exhaustiveChecks++;
                }

            }

        }

        //11. Assign index two of array as the length.
        array[2] = length;
        return array;
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition) {
        //1. Reset counters, initialize arrRecursive with size 3 in order to store the index of tail and length of snake.
        resetCounters();

        int length = 0;
        int[] arrRecursive = new int[3];
        //2.Bounds to keep snake within the game.
        if ((currentPosition[0] - 1 >= 0) && (currentPosition[0] + 1 < game.length) && (currentPosition[1] - 1 >= 0) && (currentPosition[1] + 1 < game.length - 1)) {

        //3. Base Case since  Head position is start point any point where the current position only has one tail is found.

            if (currentPosition == previousPosition) {
                length++;
                arrRecursive[0]=currentPosition[0];
                arrRecursive[1]=previousPosition[1];
                arrRecursive[2]=recursiveChecks;
        //4. Assigns the position of tail into index of array.
                return arrRecursive;
            }
        //5. Check neighbors to bottom row of head location. if not tail recursively call method.

            if ((currentPosition[0] + 1) < game.length && game[currentPosition[0] + 1][currentPosition[1]]) {
                previousPosition[0] = currentPosition[0] + 1;
                previousPosition[1] = currentPosition[1];
                length++;
                return findTailRecursive(currentPosition,previousPosition);
            }
        //6. Check neighbors to right
            if((currentPosition[1]+1)<game.length&&game[currentPosition[0]][currentPosition[1]+1]&&(!(currentPosition[0]==previousPosition[0]&&currentPosition[1]+1==previousPosition[1]))) {
                previousPosition[0]=currentPosition[0];
                previousPosition[1]=currentPosition[1]+1;
                length++;
                return findTailRecursive(headPosition,headPosition);
            }
         //7. Check neighbors above
            if(game[currentPosition[0] - 1][currentPosition[1]] && !(currentPosition[0] - 1 == previousPosition[0] && currentPosition[1] == previousPosition[1])) {

                previousPosition[0]=currentPosition[0]-1;
                previousPosition[1]=currentPosition[1];
               length++;
                findTailRecursive(currentPosition,currentPosition);
            }
         //8. Check neighbors to the left.
            if((currentPosition[1]-1)>=0&&game[currentPosition[0]][currentPosition[1]-1]&&(!(currentPosition[0]==previousPosition[0]&&currentPosition[1]-1==previousPosition[1]))) {
                previousPosition[0]=currentPosition[0];
                previousPosition[1]=currentPosition[1]-1;
               length++;
                findTailRecursive(currentPosition, currentPosition);
            }


            arrRecursive[0] = currentPosition[0];
            arrRecursive[1] = previousPosition[1];

            arrRecursive[2]= length;



        }
        return arrRecursive;
    }




    public int[] findTailRecursive() {
        resetCounters();
        return findTailRecursive(headPosition, headPosition);

    }

    private void resetCounters() {
        exhaustiveChecks = 0;
        recursiveChecks = 0;
        // reset both methods to zero.

    }

    private static int getRecursiveChecks() {

        return recursiveChecks;
    }

    private static int getExhaustiveChecks() {
        return exhaustiveChecks;
    }


}

