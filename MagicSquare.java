/*
* This program finds and prints all 3 by 3 magic number sets that add to 15.
*
* @author  Patrick Gemmell
* @version 1.0
* @since   2021-05-
*/

public final class MagicSquare {
    private MagicSquare() {
  }
  /**
  * the number three.
  */
  public static final int THREE = 3;
  /**
  * the number four.
  */
  public static final int FOUR = 4;
  /**
  * the number five.
  */
  public static final int FIVE = 5;
   /**
  * the number six.
  */
  public static final int SIX = 6;
  /**
  * the number seven.
  */
  public static final int SEVEN = 7;
   /**
  * the number eight.
  */
  public static final int EIGHT = 8;
  /**
  * the number nine.
  */
  public static final int NINE = 9;
  /**
   * the number Fifteen.
   */
  public static final int FIFTEEN = 15;
  /**
   * This function prints a magic square should one be found.
   * @param printList
   */
  static void printSquare(final int[] printList) {
    // Printing a magic square
    for (int printCounter = 0; printCounter < printList.length;
         printCounter++) {
      System.out.print(printList[printCounter] + " ");
      // Checking if three numbers are on a line
      if ((printCounter + 1) % THREE == 0) {
        System.out.println("");
      } else {
        continue;
      }
    }
    System.out.println("*****");
  }

  /**
   * This function finds and prints all 3 by 3 magic number sets that add to 15.
   * @param numberList
   * @param indexList
   * @param index
   */
  static void solveSquares(final int[] numberList,
                           final int[] indexList, final int index) {
    // This loop itterates to fill out a square of numbers
    for (int counter = 0; counter < numberList.length; counter++) {
      // Checking if a slot in the square has been occupied
      if (indexList[counter] == 0) {
        numberList[counter] = index;
        indexList[counter] = 1;

        // Checking if the index is less than nine
        if (index < NINE) {
          // Calling function again to continue creating square
          solveSquares(numberList, indexList, index + 1);
        } else {
          // Checking if every linear combination of three numbers adds to 15
          if (isSquareMagic(numberList)) {
            // Printing out the square that was found
            printSquare(numberList);
          }
        }

        // Reseting part of the square to 0 so it can be filled again
        indexList[counter] = 0;
      }
    }
  }

  /**
   * This function determines whether or not a square is a magic square.
   * @param squareList
   * @return
   * returns list
   */
  static boolean isSquareMagic(final int[] squareList) {
    // Performing math that determines the sum of array number combinations
    int firstRow = squareList[0] + squareList[1] + squareList[2];
    int secondRow = squareList[THREE] + squareList[FOUR] + squareList[FIVE];
    int thirdRow = squareList[SIX] + squareList[SEVEN] + squareList[EIGHT];
    int firstColumn = squareList[0] + squareList[THREE] + squareList[SIX];
    int secondColumn = squareList[1] + squareList[FOUR] + squareList[SEVEN];
    int thirdColumn = squareList[2] + squareList[FIVE] + squareList[EIGHT];
    int firstDiagonal = squareList[0] + squareList[FOUR] + squareList[EIGHT];
    int secondDiagonal = squareList[2] + squareList[FOUR] + squareList[SIX];

    // If statement that finds whether or not the numbers form a magic square
    return (firstRow == FIFTEEN && secondRow == FIFTEEN && thirdRow == FIFTEEN
        && firstColumn == FIFTEEN && secondColumn == FIFTEEN
        && thirdColumn == FIFTEEN
        && firstDiagonal == FIFTEEN && secondDiagonal == FIFTEEN);
  }

  /**
   * This function passes variables into a function that will find print all
   * 3 by 3 magic number sets that add to 15.
   * @param args
   */
  public static void main(final String[] args) {
    // Initializing the list that will be used in determining the magic squares
    int[] firstList = {1, 2, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
    int[] secondList = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    // Printing the inital dividing line
    System.out.println("*****");

    // Calling the function that will solve the magic squares
    solveSquares(firstList, secondList, 1);
  }
}
