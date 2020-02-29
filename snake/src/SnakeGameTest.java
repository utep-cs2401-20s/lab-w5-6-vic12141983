import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeGameTest {

    @Test
    // Test one make entire borad false.
    // Expecting an empty array to be returned
    // Test passed


    void findTailRecursive() {


            boolean[][] game = {
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
            };

            SnakeGame test1 = new SnakeGame(game, 0, 1);

            int[] snake = new int[3];
            snake[0] = 0;
            snake[1] = 0;
            snake[2] = 0;
            assertArrayEquals(snake, test1.findTailRecursive());



    }
    // Test2
    // Test with a different head Position input
    // Expectation fail
    // Due to head beginning at index 0,1
    // test failed
    @org.junit.jupiter.api.Test
    void findTailRecursive1() {


        boolean[][] game = {
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true,  true,true},
                {true, true, true, true, true},
        };

        SnakeGame test2 = new SnakeGame(game, 0, 3);

        int[] snake = new int[3];
        snake[0] = 0;
        snake[1] = 0;
        snake[2] = 0;
        assertArrayEquals(snake, test2.findTailRecursive());



    }// Test3
    // Testing with an empty array
    // Expectation method will not run
    // failed.
    @org.junit.jupiter.api.Test
    void findTailRecursive2() {


        boolean[][] game = {};


        SnakeGame test3 = new SnakeGame(game, 0, 3);

        int[] alive = new int[3];
        alive[0] = 0;
        alive[1] = 0;
        alive[2] = 0;
        assertArrayEquals(alive, test3.findTailRecursive());



    }
    // Testing with integers using a boolean array
    // Expectation fail
    // Boolean expected
    // Correction by not making an integer array
    @org.junit.jupiter.api.Test
    void findTailRecursive3() {


        int [][] game = {{1,0,0,0},{1,2,1,1}};


        SnakeGame test4 = new SnakeGame(game, 0, 1);

        int[] alive = new int[3];
        alive[0] = 0;
        alive[1] = 0;
        alive[2] = 0;
        assertArrayEquals(alive, test4.findTailRecursive());



    }

    // TEsting with all true Expect infinite loop
    // Base case is not met
    // Recursive call will continue until one condidtion is met
    // In this case it would not happen. Method would cause infinite loop
    // Failed.
    @org.junit.jupiter.api.Test
    void findTailRecursive4() {

        boolean[][] game = {
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true,  true,true},
                {true, true, true, true, true},
        };





        SnakeGame test5 = new SnakeGame(game, 0, 1);

        int[] alive = new int[3];
        alive[0] = 3;
        alive[1] = 4;
        alive[2] = 20;
        assertArrayEquals(alive, test5.findTailRecursive());



    }





    @org.junit.jupiter.api.Test
        //Test1. Testing  Exhaustive method to ensure it works
        // Pass array with all zeros expect all zeros in return.
        // Test results passed.
    void findTailExhaustive() {
        int[][] test = {{0, 0,}, {0, 0}, {0, 0}};
        int[] answer = {0, 0, 0};


        SnakeGame test1 = new SnakeGame(test, 0, 1);
        assertArrayEquals(answer, test1.findTailExhaustive());
    }

    // Test2. Testing with negative integers outside the bounds of game board
    // Expectations is to either fail or increase the number of checks.
    // Test case failed not from expectations rather that method is working with provided information of array
    // In order to change this solution is modify current array and ensure all parameters are met.
    @org.junit.jupiter.api.Test
    void findTailExhaustive2() {
        int[][] test1 = {{1, 0},
                {1, 1},
                {1, 1}};
        int[] answer2 = {0, 1, 3};
        SnakeGame test2 = new SnakeGame(test1, 0, 1);
        assertArrayEquals(answer2, test2.findTailExhaustive());


    }
    // Test3 Again method seems to be running, Seems array is incorrect currently
    // No solution to test this otherwise actual will always be zero.

    @org.junit.jupiter.api.Test
    void findTailExhaustive3() {
        int[][] test2 = {{1, 1, 0},
                {1, 0, 0},
                {1, 1, 0}};
        int[] answer3 = {0, 0, 0};
        SnakeGame test3 = new SnakeGame(test2, 0, 0);
        assertArrayEquals(answer3, test3.findTailExhaustive());

    }

    // Test 4 after verifying that array had to be a boolean
    // corrections were made
    // testing with board completly full
    // Expecting infinite search since no conditions were met
    // Null pointer exception was result.
    // Modifiy code to handle null pointer to correct.
    @org.junit.jupiter.api.Test
    void findTailExhaustive4() {

        boolean o = true;

        boolean[][] game = {
                {o, o, o, o, o},
                {o, o, o, o, o},
                {o, o, o, o, o},
                {o, o, o, o, o},
        };
        SnakeGame test3 = new SnakeGame(game, 0, 0);

        int[] test = new int[3];
        test[0] = 1;
        test[1] = 4;
        test[2] = 20;
        assertArrayEquals(test, test3.findTailExhaustive());

    }

    // Test 5. testing snake with a break in the snake
    // Expect failure due to first snake has no neighbors so none of conditions are met for tail and head
    // Test Failed.
    @Test
    public void testFindTailExhaustive5() {
        boolean Snake = true;
        boolean dead = false;
        boolean[][] game = {
                {dead, dead, dead, dead, Snake},
                {dead, Snake,Snake,Snake,dead},
                {dead, Snake,dead, dead, dead},
                {dead, Snake,Snake,Snake,dead},
        };

        SnakeGame test4 = new SnakeGame(game, 0, 4);

        int[] snake = new int[3];
        snake[0] = 4;
        snake[1] = 4;
        snake[2] = 1;
        assertArrayEquals(snake, test4.findTailExhaustive());

    }
}