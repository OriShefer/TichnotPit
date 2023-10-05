import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StringCalculator {
    public static int execute(String expression) {

        expression = removeSpaces(expression);
        String[] operands = getOperands(expression);
        String[] operators = getOperators(expression);
        int operandsIndex = 0;
        int operatorsIndex = 0;

        int sum = 0;

        int num1 = Integer.parseInt(operands[operandsIndex]);
        int num2 = Integer.parseInt(operands[operandsIndex+ 1]) ;

        while (operandsIndex != operands.length && operatorsIndex != operators.length){

            num2 = Integer.parseInt(operands[operandsIndex+ 1]);

            if(operators[operatorsIndex].equals("-"))
                sum = num1 - num2;
            else
                sum = num1 + num2;

            operatorsIndex++;
            operandsIndex++;

            num1 = sum;

        }


        return sum;
    }

    public static String removeSpaces(String line) {

        return line.replaceAll(" ","");

    }

    public static String[] getOperators(String expression) {

        ArrayList<Character> operatorsChars = new ArrayList<Character>();
        for (int i = 0; i < expression.length(); i++)
            if(expression.charAt(i) < '0' || expression.charAt(i) > '9')
                operatorsChars.add(expression.charAt(i));

        String[] operators = new String[operatorsChars.size()];

        for (int i = 0; i < operatorsChars.size(); i++)
            operators[i] = String.valueOf(operatorsChars.get(i));

        return operators;
    }

    public static String[] getOperands(String expression) {

        ArrayList<String> operandsList = new ArrayList<String>();


        int index = 0;
        int lastOperatorIndex = 0;
        while (index < expression.length()){
            while( index < expression.length() && expression.charAt(index) != '-' && expression.charAt(index) != '+')
                index++;

            operandsList.add(expression.substring(lastOperatorIndex,index));
            index++;
            lastOperatorIndex = index;
        }

        String[] operands = new String[operandsList.size()];
        return operandsList.toArray(operands);

    }

    public static boolean validateExpression(String expression) {

        String chars = "+-0123456789";

        for (int i = 0; i < expression.length(); i++)
            if(chars.indexOf(expression.charAt(i)) == -1)
                return false;

        return expression.contains("+") || expression.contains("-");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String EXIT_CODE = "EXIT";

        System.out.printf("Enter math expression or %s to exit: \n", EXIT_CODE);
        String expression = scanner.nextLine();

        while (!expression.equals(EXIT_CODE)) {
            if (!validateExpression(expression)) {
                System.out.println("Expression invalid, must contain digits and + or - operators only");
            } else {
                System.out.println("Result: " + execute(expression));
            }

            System.out.printf("Enter math expression or %s to exit: \n", EXIT_CODE);
            expression = scanner.nextLine();
        }
    }
}
