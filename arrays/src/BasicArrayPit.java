import java.util.Scanner;

public class BasicArrayPit {
  public static String getInput(String prompt) {
    System.out.println(prompt);
    Scanner input = new Scanner(System.in);

    return input.nextLine();
  }

  // 1
  public static void printReversed() {
    int[] userInput = new int[10];

    for (int index = 0; index < userInput.length; index++) {
      userInput[index] = Integer.parseInt(getInput("Enter a Number"));
    }

    for (int index = userInput.length; index > 0; index--) {
      System.out.println(userInput[index - 1]);
    }
  }

  // 2
  public static boolean areArraysIdentical(int[] firstArray, int[] secondArray) {
    return Arrays.equals(firstArray, secondArray);
  }

  // 3
  public static void swapArray(int[] arrayToSwap) {
    for (int index = 0; index < arrayToSwap.length / 2; index++) {
      int temp = arrayToSwap[index];
      arrayToSwap[index] = arrayToSwap[arrayToSwap.length - index - 1];
      arrayToSwap[arrayToSwap.length - index - 1] = temp;
    }
  }

  // 4
  public static boolean doesArrayContain(int[] checkedArray, int[] containedArray) {
    for (int startIndex = 0; startIndex < checkedArray.length - containedArray.length; startIndex++) {
      boolean isIdentical = true;

      for (int searchIndex = 0; isIdentical && (searchIndex < containedArray.length); searchIndex++) {
        if (checkedArray[startIndex + searchIndex] != containedArray[searchIndex]) {
          isIdentical = false;
        }
      }

      if (isIdentical) {
        return true;
      }
    }

    return false;
  }

  // 5
  public static int[] sumArrays(int[] firstArray, int[] secondArray) {
    int[] sumArray = new int[firstArray.length];

    for (int index = 0; index < firstArray.length; index++) {
      sumArray[index] = firstArray[index] + secondArray[index];
    }

    return sumArray;
  }

  // 6
  public static int closestValueToAverage(int[] array) {
    return closestValue(array, averageOfArray(array));
  }

  public static int averageOfArray(int[] array) {
    int sum = 0;

    for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {
      sum += array[currentIndex];
    }

    return (int) sum / array.length;
  }

  public static int closestValue(int[] array, int value) {
    int closestValue = Math.abs(array[0] - value);

    for (int currentIndex = 1; currentIndex < array.length; currentIndex++) {
      if (Math.abs(closestValue - value) > Math.abs(array[currentIndex] - value)) {
        closestValue = Math.abs(array[currentIndex] - value);
      }
    }

    return closestValue;
  }

  // 7
  public static void printLargestAscendingSeries(int[] arrayToCheck) {
    int seriesSize = 1;
    int currMax = 0;
    int startIndex = 0;

    for (int index = 1; index < arrayToCheck.length; index++) {
      if (arrayToCheck[index - 1] < arrayToCheck[index]) {
        seriesSize++;
      } else {
        seriesSize = 1;
      }

      if (seriesSize > currMax) {
        currMax = seriesSize;
        startIndex = index - seriesSize + 1;
      }
    }

    System.out.println(
        "The largest series size is " + currMax + " and its start index is " + startIndex);
  }

  // 8
  public static void printUniqueValues() {
    boolean[] usedNumbers = markUniqueValues(50);

    for (int printIndex = 0; printIndex < usedNumbers.length; printIndex++) {
      if (!usedNumbers[printIndex]) {
        System.out.print(printIndex + ", ");
      }
    }
  }

  public static boolean[] markUniqueValues(final int MAX_NUMBER) {
    final int EXIT_CODE = -999;

    boolean[] usedNumbers = new boolean[MAX_NUMBER];

    for (int index = 0; index < usedNumbers.length; index++) {
      usedNumbers[index] = false;
    }

    int userChoice = Integer.parseInt(getInput(
        "Input numbers between 0 and "
            + MAX_NUMBER
            + " until exit code of "
            + EXIT_CODE));

    while (userChoice != EXIT_CODE) {
      usedNumbers[userChoice] = true;

      userChoice = Integer.parseInt(getInput("Enter a Number"));
    }

    return usedNumbers;
  }

  // 9
  public static void cyclicMovement(int[] arrayToMove, int amountOfMoves) {
    int[] movedArray = new int[arrayToMove.length];

    for (int index = 0; index < arrayToMove.length; index++) {
      movedArray[(index + amountOfMoves) % movedArray.length] = arrayToMove[index];
    }

    for (int index = 0; index < arrayToMove.length; index++) {
      System.out.print(movedArray[index] + ", ");
    }
  }
}
