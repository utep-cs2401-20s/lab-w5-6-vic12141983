import static org.junit.jupiter.api.Assertions.*;

class SnakeGameTest {

    @org.junit.jupiter.api.Test
    void finTailRecursive() {

    }

    @org.junit.jupiter.api.Test
    //Test1. Testing  Exhaustive method to ensure it works
    // Pass array with all zeros expect all zeros in return.
    // Test results passed.
    void findTailExhaustive() {
        int [][] test = {{0,0,},{0,0},{0,0}};
        int [] answer = {0,0,0};


        SnakeGame test1 = new SnakeGame(test,0, 1);
        assertArrayEquals(answer,test1.findTailExhaustive());
    }
    // Test2. Testing with negative integers outside the bounds of game board
    // Expectations is to either fail or increase the number of checks.
    // Test case failed not from expectations rather that method is working with provided information of array
    // In order to change this solution is modify current array and ensure all parameters are met.
    @org.junit.jupiter.api.Test
    void findTailExhaustive2(){
        int [][] test1 = {{1,0},
                           {1,1},
                           {1,1}};
        int [] answer2 ={0,1,3};
        SnakeGame test2 =new SnakeGame(test1,0,1);
        assertArrayEquals(answer2,test2.findTailExhaustive());



    }
    // Test3 Again method seems to be running, Seems array is incorrect currently
    // No solution to test this otherwise actual will always be zero.

    @org.junit.jupiter.api.Test
    void findTailExhaustive3(){
        int [][] test2 = {{1,1,0},
                          {1,0,0},
                          {1,1,0}};
        int [] answer3 ={0,0,0};
        SnakeGame test3 = new SnakeGame(test2,0,0);
        assertArrayEquals(answer3,test3.findTailExhaustive());

    }
    // Test 4 after verifying that array had to be a boolean
    // corrections were made
    // testing with board completly full
    // Expecting infinite search since no conditions were met
    // Null pointer exception was result.
    // Modifiy code to handle null pointer to correct. 
    @org.junit.jupiter.api.Test
    void findTailExhaustive4(){

            boolean o=true;

            boolean [][] game= {
                    {o,o,o,o,o},
                    {o,o,o,o,o},
                    {o,o,o,o,o},
                    {o,o,o,o,o},
            };
            SnakeGame test3 = new SnakeGame(game,  0, 0);

            int [] test = new int [3];
            test[0] = 3;
            test[1] = 4;
            test[2] = 20;
            assertArrayEquals(test,test3.findTailExhaustive());

    }

}