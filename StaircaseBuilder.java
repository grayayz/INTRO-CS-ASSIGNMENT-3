/*
 * Write your program inside the main method to build
 * a staicase in a 2D array of characters according
 * to the assignment description
 *
 * To compile:
 *        javac StaircaseBuilder.java
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 */
public class StaircaseBuilder {

  public static void main(String[] args) {
    if (args.length < 2) {
      return;
    }

    int d = Integer.parseInt(args[0]);  // dimension of 2D array
    int totalBricks = Integer.parseInt(args[1]);  // total number of bricks

    char[][] stairs = new char[d][d];  // initialize 2D array
    for (int i = 0; i < d; i++) {
      for (int j = 0; j < d; j++) {
        stairs[i][j] = ' ';  // fill with empty spaces initially
      }
    }

    int bricksUsed = buildStaircase(stairs, d, totalBricks);
    printStaircase(stairs, d);  // print the 2D array
    System.out.println("Bricks remaining: " + (totalBricks - bricksUsed));
  }

private static int buildStaircase(char[][] stairs, int d, int totalBricks) {
    int bricksUsed = 0;

    for (int step = 1; step <= d && totalBricks > 0; step++) {
        int row = d - step;         // start from the bottom row
        int startingCol = d - step; // each row starts one column further left

        for (int col = startingCol; col < d && totalBricks > 0; col++) {
            stairs[row][col] = 'X';
            bricksUsed++;
            totalBricks--;
        }
    }

    return bricksUsed;
}

  private static void printStaircase(char[][] stairs, int d) {
    for (int i = 0; i < d; i++) {
      for (int j = 0; j < d; j++) {
        System.out.print(stairs[i][j]);
      }
      System.out.println();
    }
  }
}
