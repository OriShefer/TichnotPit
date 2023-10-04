import java.util.Scanner;

public class Main {
    public static long whiteSmokeCode(long numberToCode, int specialDigit, int reverseAmount) {
        long encodedNumber = numberToCode;
        int currDigitIndex = 0;
        long digitsAmount = countNumDigits(numberToCode);

        while (numberToCode != 0) {
            numberToCode = reverseNumber(numberToCode);
            long currDigit = numberToCode  % 10;

            if (currDigit == specialDigit) {
                encodedNumber = reverseNumFromIndex(encodedNumber, reverseAmount, currDigitIndex + 1);
                numberToCode = reverseNumber(encodedNumber % (int)Math.pow(10, digitsAmount - currDigitIndex - 1));
            } else {
                numberToCode /= 10;
            }

            currDigitIndex++;
            numberToCode = reverseNumber(numberToCode);
        }

        return encodedNumber;
    }

    public static long reverseNumFromIndex(long number, int amountToReverse, int startIndex) {
        int currDigitIndex = 0;
        long finalNumber = number;
        long digitsAmount = countNumDigits(number);
        number = reverseNumber(number);

        while (number != 0 && currDigitIndex != startIndex) {
            number /= 10;
            currDigitIndex++;
        }

        number = reverseNumber(number);
        long tempNumLength = countNumDigits(number);

        if (tempNumLength > amountToReverse) {
            number /= Math.pow(10, tempNumLength - amountToReverse);
        } else if (tempNumLength < amountToReverse) {
            amountToReverse = (int)(tempNumLength % amountToReverse);
        }

        for (int digitIndex = 0; digitIndex < amountToReverse; digitIndex++) {
            finalNumber -=
                    digitAtIndex(finalNumber, currDigitIndex + digitIndex)
                            * Math.pow(10, digitsAmount - currDigitIndex - digitIndex - 1);
            finalNumber += number % 10 * Math.pow(10, digitsAmount - currDigitIndex - digitIndex - 1);
            number /= 10;
        }

        return finalNumber;
    }

    public static long digitAtIndex(long finalNumber, int index) {
        int counter = 0;
        finalNumber = reverseNumber(finalNumber);

        while (finalNumber != 0 && counter != index) {
            finalNumber /= 10;
            counter++;
        }

        if (finalNumber == 0) {
            return -1;
        }

        return finalNumber % 10;
    }

    public static long countNumDigits(long number) {
        int counter = 0;

        while (number != 0) {
            number /= 10;
            counter++;
        }

        return counter;
    }

    public static long reverseNumber(long number) {
        long reversed = 0;

        while (number != 0) {
            long digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        return reversed;
    }

    public static boolean isGoodEncode(long encodedNumber, int specialDigit) {
        int count = 0;
        long originalNumberLength = countNumDigits(encodedNumber);

        while (encodedNumber != 0) {
            if (encodedNumber % 10 == specialDigit && encodedNumber / 10 % 10 == specialDigit + 1) {
                count++;
            }
            encodedNumber /= 10;
        }

        return count > originalNumberLength / 6;
    }
}
