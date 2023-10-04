import java.util.Scanner;

public class MainHostess {
    private static final int OCCUPY_TABLE = 1;
    private static final int GET_DINERS_AMOUNT = 2;
    private static final int LEAVE_TABLE = 3;
    private static final int PRINT_TABLES = 4;
    private static final int REMOVE_BY_DINERS_AMOUNT = 5;
    private static final int EXIT = 6;
    private static final int MAX_DINERS_IN_TABLE = 3;

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        printMenu();
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();

        while (userChoice != EXIT) {
            switch (userChoice) {
                case OCCUPY_TABLE:
                    occupyTable(restaurant);

                    break;
                case GET_DINERS_AMOUNT:
                    getDinersAmount(restaurant);

                    break;
                case LEAVE_TABLE:
                    leaveTable(restaurant);

                    break;
                case PRINT_TABLES:
                    restaurant.printOccupiedTables();

                    break;
                case REMOVE_BY_DINERS_AMOUNT:
                    restaurant.removeByDinersAmount(MAX_DINERS_IN_TABLE);

                    break;
                default:
                    System.out.println("You entered an invalid code, please enter again");

                    break;
            }

            printMenu();
            userChoice = scanner.nextInt();
        }
    }

    private static void occupyTable(Restaurant restaurant) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter table number: ");
        int tableNumber = scanner.nextInt();
        System.out.println("Enter diners amount: ");
        int dinersAmount = scanner.nextInt();

        if (dinersAmount <= 0) {
            System.out.println("You need at least 1 person to be seated");
        } else if (!restaurant.occupyTable(tableNumber, dinersAmount)) {
            System.out.println("Table is not available");
        } else {
            System.out.println(dinersAmount + " people are now seated at table " + tableNumber);
        }
    }

    private static void leaveTable(Restaurant restaurant) {
        System.out.println("Enter table number: ");
        Scanner scanner = new Scanner(System.in);
        int leavingTableNum = scanner.nextInt();

        if (!restaurant.leaveTable(leavingTableNum)) {
            System.out.println("Table is unoccupied");
        } else {
            System.out.println("Table " + leavingTableNum + " is now available");
        }
    }

    private static void getDinersAmount(Restaurant restaurant) {
        System.out.println("Enter table number: ");
        Scanner scanner = new Scanner(System.in);
        int tableNumber = scanner.nextInt();

        int dinersAmount = restaurant.dinersByTable(tableNumber);
        System.out.println(dinersAmount + " people are now seated at table " + tableNumber);
    }



    private static void printMenu() {
        System.out.println("\nMenu: \n===================\n");
        System.out.println(
                OCCUPY_TABLE
                        + ": To seat diners at a table \n"
                        + GET_DINERS_AMOUNT
                        + ": To get diners amount of a table \n"
                        + LEAVE_TABLE
                        + ": To clear a table \n"
                        + PRINT_TABLES
                        + ": To print all occupied tables \n"
                        + REMOVE_BY_DINERS_AMOUNT
                        + ": To enforce corona limitations \n"
                        + EXIT
                        + ": To exit \n"
                        + "Enter your choice");
    }
}