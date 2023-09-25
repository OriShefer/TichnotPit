import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int RECTANGULAR_BUILDING_CODE = 1;
        final int TRIANGULAR_BUILDING_CODE = 2;
        final int EXIT_CODE = 3;
        System.out.println("Welcome to Twitter Towers!");
        printMenu(RECTANGULAR_BUILDING_CODE, TRIANGULAR_BUILDING_CODE, EXIT_CODE);
        int buildingChoice = Integer.parseInt(getInput());

        while (buildingChoice != EXIT_CODE) {
            int height = Integer.parseInt(getInput("Enter building height:"));
            int width = Integer.parseInt(getInput("Enter building width:"));

            if (buildingChoice == RECTANGULAR_BUILDING_CODE) {
                buildRectangularBuilding(height, width);
            } else if (buildingChoice == TRIANGULAR_BUILDING_CODE) {
                buildTriangularBuilding(height, width);
            } else {
                System.out.println("Invalid code inserted, please try again");
            }

            printMenu(RECTANGULAR_BUILDING_CODE, TRIANGULAR_BUILDING_CODE, EXIT_CODE);
            buildingChoice = Integer.parseInt(getInput());
        }
    }

    public static String getInput(){
        Scanner userInput = new Scanner(System.in);

        return userInput.nextLine();
    }

    public static String getInput(String prompt){
        Scanner userInput = new Scanner(System.in);
        System.out.println(prompt);

        return userInput.nextLine();
    }

    public static void printMenu(final int RECTANGULAR_BUILDING_CODE,
                                 final int TRIANGULAR_BUILDING_CODE,
                                 final int EXIT_CODE) {
        System.out.println("Insert number of building to build:");
        System.out.println(RECTANGULAR_BUILDING_CODE + " - Rectangular building");
        System.out.println(TRIANGULAR_BUILDING_CODE + " - Triangular building");
        System.out.println(EXIT_CODE + " - Exit program");
    }

    public static double calcPerimeter(int width, int height){
        double triangleSide = Math.sqrt(Math.pow(height, 2) + Math.pow((double) width / 2, 2));
        return triangleSide * 2 + width;
    }

    public static boolean isTrianglePrintable(int width, int height){
        return width % 2 != 0 && width <= 2 * height;
    }

    public static void buildRectangularBuilding(int height, int width) {
        if (height == width || Math.abs(height - width) > 5) {
            System.out.println("The rectangular building area is: " + width * height);
        } else {
            System.out.println("The rectangular building perimeter is: " + 2 * (width + height));
        }
    }

    public static void buildTriangularBuilding(int height, int width) {
        final int PERIMETER_CODE = 1;
        final int PRINT_CODE = 2;
        System.out.println("Insert code of wanted action: ");
        System.out.println(PERIMETER_CODE + " - Print building's perimeter");
        System.out.println(PRINT_CODE + " - Print the building");
        Scanner userInput = new Scanner(System.in);
        int actionCode = userInput.nextInt();

        if (actionCode == PERIMETER_CODE) {
            System.out.println("The triangle perimeter is " + calcPerimeter(width, height));
        } else if (actionCode == PRINT_CODE) {
            if (!isTrianglePrintable(width, height)) {
                System.out.println("Unable to print this triangle building.");
            } else {
                int asteriskAmount = 3;
                final int groupNum = width / 2 - 1;
                final int rowNumInGroup = (height - 2) / groupNum;
                printAsterisks(width, 1);

                for (int index = rowNumInGroup * groupNum; index < height - 2; index++) {
                    printAsterisks(width, asteriskAmount);
                }

                for (int groupIndex = 1; groupIndex <= groupNum; groupIndex++) {
                    for (int rowIndex = 1; rowIndex <= rowNumInGroup; rowIndex++) {
                        printAsterisks(width, asteriskAmount);
                    }

                    asteriskAmount += 2;
                }

                printAsterisks(width, width);
            }
        } else {
            System.out.println("Invalid code inserted");
        }
    }

    public static void printAsterisks(int length, int asteriskAmount) {
        for (int spaces = 0; spaces < length; spaces++) {
            if (spaces >= (length - asteriskAmount) / 2 && spaces < (length + asteriskAmount) / 2) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}