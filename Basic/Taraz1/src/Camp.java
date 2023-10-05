import java.util.Scanner;

public class Camp {
    public static void main(String[] args) {
        final int EXIT_CODE = -999;
        final int YOUNGER_GROUP_MIN_AGE = 8;
        final int OLDER_GROUP_MAX_AGE = 15;
        final int YOUNGER_GROUP_MAX_AGE = 11;
        final int YOUNGER_GROUP_STUDENTS_PER_INSTRUCTOR = 4;
        final int OLDER_GROUP_STUDENTS_PER_INSTRUCTOR = 7;

        int olderGroupStrength = 0;
        int youngerGroupStrength = 0;
        int youngerGroupMembersCount = 0;
        int olderGroupMembersCount = 0;

        int childAge = getInputInRange(YOUNGER_GROUP_MIN_AGE, OLDER_GROUP_MAX_AGE, EXIT_CODE, "Enter child age: ");

        while (childAge != EXIT_CODE) {
            int childWeight = getPositiveInput("Enter child's weight: ");
            int childHeight = getPositiveInput("Enter child's height: ");
            int childStrength = calcChildStrength(childAge, childWeight, childHeight);

            if (childAge <= YOUNGER_GROUP_MAX_AGE) {
                youngerGroupStrength += childStrength;
                youngerGroupMembersCount++;
            } else {
                olderGroupStrength += childStrength;
                olderGroupMembersCount++;
            }

            childAge = getInputInRange(YOUNGER_GROUP_MIN_AGE, OLDER_GROUP_MAX_AGE, EXIT_CODE, "Enter child age: ");
        }

        int instructorsNeeded = 0;

        if (youngerGroupMembersCount == 0) {
            System.out.println("Younger Group has no members");
        } else {
            instructorsNeeded +=
                    calculateInstructors(youngerGroupMembersCount, YOUNGER_GROUP_STUDENTS_PER_INSTRUCTOR);
            System.out.println("Younger Group");
            printDetails(youngerGroupStrength, youngerGroupMembersCount);
        }

        if (olderGroupMembersCount == 0) {
            System.out.println("Older Group has no members");
        } else {
            instructorsNeeded +=
                    calculateInstructors(olderGroupMembersCount, OLDER_GROUP_STUDENTS_PER_INSTRUCTOR);
            System.out.println("Second Group");
            printDetails(olderGroupStrength, olderGroupMembersCount);
        }

        System.out.println("Amount of instructors needed for camp: " + instructorsNeeded);
    }

    public static void printDetails(int groupStrength, int membersCount) {
        System.out.println("----------------");
        System.out.println("Group Strength: " + groupStrength);
        System.out.println("Group members count: " + membersCount);
        System.out.println("----------------");
    }

    public static int calcChildStrength(int childAge, int childWeight, int childHeight) {
        return (fibonacciByIndex(childAge) + (childHeight / (childWeight + 10)));
    }

    public static int calculateInstructors(
            int groupMembersCount, final int GROUP_STUDENTS_PER_INSTRUCTOR) {

        int instructorsNeeded = groupMembersCount / GROUP_STUDENTS_PER_INSTRUCTOR;

        if ((groupMembersCount % GROUP_STUDENTS_PER_INSTRUCTOR) > 0) {
            instructorsNeeded++;
        }

        return instructorsNeeded;
    }

    public static String getInput(String prompt){
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);

        return input.nextLine();
    }

    public static int getInputInRange(int min, int max, int exitCode, String prompt) {
        int input = Integer.parseInt(getInput(prompt));

        while (((input > max) || (input < min)) && (input != exitCode)) {
            input = Integer.parseInt(getInput("Input must be between " + min + " and " + max));
        }

        return input;
    }

    public static int getPositiveInput(String prompt) {
        int input = Integer.parseInt(getInput(prompt));

        while (input < 0) {
            input = Integer.parseInt(getInput("input must be positive, Try again"));
        }

        return input;
    }

    public static int fibonacciByIndex(int index) {
        int currValue = 1;
        int prevValue = 1;

        for (int currValueIndex = 3; currValueIndex <= index; currValueIndex++) {
            currValue += prevValue;
            prevValue = currValue - prevValue;
        }

        return currValue;
    }
}
