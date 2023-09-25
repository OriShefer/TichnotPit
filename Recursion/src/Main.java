public class Main {

    //1
    public static int sumArr (int[] arr, int index){

        if (index == arr.length) {
            return 0;
        }

        return (arr[index] + sumArr(arr, index + 1));
    }


    //2
    public static int numOfChar (String str,char c ,int index){

        if (index == str.length())
            return 0;


        if(str.charAt(index) == c)
            return 1 + numOfChar(str, c , index + 1);

        return numOfChar(str, c , index + 1);

    }

    //3
    public static boolean isPalindrome (int[] arr, int index){

        if(index == arr.length / 2)
            return true;

        if(arr[index] == arr[arr.length - index - 1])
            return isPalindrome(arr, index + 1);

        return false;

    }

    // 4
    public static void printDividers(int number) {
        System.out.print("dividers for " + number + ": ");
        printDividers(number, 2);
    }

    private static void printDividers(int number, int divider) {
        if (number >= (divider * 2)) {
            if (number % divider == 0) {
                System.out.print(divider + ", ");
            }

            printDividers(number, divider + 1);
        }
    }

    // 6
    public static int countOfDigitsInNum(int number, int digit) {
      if( number == 0 )
          return 0;

      if(number % 10 == digit)
          return 1+ countOfDigitsInNum(number / 10, digit);

      return countOfDigitsInNum(number / 10, digit);
    }

    //7
    public static String base10ToBase2(int number) {

        if(number == 0)
            return "";

        return base10ToBase2(number / 2) + number % 2;
    }

    public static int decimalToBinary(int decimalNumber) {
        if (decimalNumber == 0) {
            return 0;
        }

        return (decimalNumber % 2 + 10 *
                decimalToBinary(decimalNumber / 2));
    }

    // 8
    public static int fibonacci(int number) {
        if (number == 0 || number == 1) {
            return number;
        }

        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,5,1};
        System.out.println(decimalToBinary(25));
    }
}