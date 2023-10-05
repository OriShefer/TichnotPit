
import java.util.Scanner;


public class Main {
    static final int CODE_CHANGE_GRADE = 1;
    static final int CODE_CALC_AVARAGE = 2;
    static final int CODE_CALC_SUM = 3;
    static final int CODE_PRINT_ALL = 4;
    static final int CODE_EXIT = 5;
    static final int PEOPLE_NO = 3;

    public static void printMenu() {
        System.out.println("What would you like to do?");
        System.out.println("--------------------------");
        System.out.println(CODE_CHANGE_GRADE + ": To change grade");
        System.out.println(CODE_CALC_AVARAGE + ": To calculate the grades avarage");
        System.out.println(CODE_CALC_SUM + ": To calculate the grades sum");
        System.out.println(CODE_PRINT_ALL + ": To print the list");
        System.out.println(CODE_EXIT + ": To exit");
        System.out.println("Your choice: ");
    }

    public static int findStudentByName(String[] studentsNames, String studentName) {
        Scanner scanner = new Scanner(System.in);
        int studentToChange = 0;

        for(int currSearchedStudent = 0;
            (currSearchedStudent < PEOPLE_NO) && (studentsNames[currSearchedStudent] == studentName);
            currSearchedStudent++) {
            ++studentToChange;
        }

        return studentToChange;
    }

    public static int findStudentById(int[] studentIds, int id) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int studentToChange = 0;

        for (int currSearchedStudent = 0;
             (currSearchedStudent < PEOPLE_NO) && (studentIds[currSearchedStudent] != id);
             ++currSearchedStudent) {
            ++studentToChange;
        }


        return studentToChange;
    }

    public static void sortByGrade(int[] gradesArr)
    {
        int coupleIterationCount = 0;
        boolean didBubbleHappened =  true;
        for (int lastIndex = gradesArr.length - 2; (lastIndex >= 0) && (didBubbleHappened) ; lastIndex--) {
            didBubbleHappened = false;
            for (int currentIndex = 0; currentIndex <= lastIndex ; currentIndex++) {
                coupleIterationCount++;
                if (gradesArr[currentIndex] > gradesArr[currentIndex + 1]) {
                    int helpNumber = gradesArr[currentIndex];
                    gradesArr[currentIndex] = gradesArr[currentIndex + 1];
                    gradesArr[currentIndex + 1] = helpNumber;
                    didBubbleHappened = true;
                }
            }
        }
    }

    public static void printGradesList(int[] studentIds, String[] studentsNames, int[] studentsGrades) {
        System.out.println("The list of students: ");
        System.out.println("--------------------");

        sortByGrade(studentsGrades);

        for(int currDisplayedStudent = 0;
            currDisplayedStudent < PEOPLE_NO;
            ++currDisplayedStudent) {
            System.out.println(studentsNames[currDisplayedStudent] + " " +
                    studentIds[currDisplayedStudent] +
                    ": " + studentsGrades[currDisplayedStudent]);
        }
    }

    public static void main(String[] args) {
        final int PERSONAL_CODE = 1;
        final int NAME_CODE = 2;

        int[] studentsGrades = new int[PEOPLE_NO];
        int[] studentIds = new int[PEOPLE_NO];
        String[] studentsNames = new String[PEOPLE_NO];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the grade systems");
        System.out.println("----------------------------");

        for(int studentIndex = 0; studentIndex < PEOPLE_NO; ++studentIndex) {
            System.out.println("Enter your name: ");
            String studentFullName = scanner.nextLine();
            System.out.println("Enter your id: ");
            studentIds[studentIndex] = scanner.nextInt();
            scanner.nextLine();
            studentsNames[studentIndex] = studentFullName;
            //studentIndex--;
        }

        for(int studentIndex = 0; studentIndex < PEOPLE_NO; ++studentIndex)  {
            studentsGrades[studentIndex] = 0;
        }

        printMenu();
        int currCode = scanner.nextInt();
        scanner.nextLine();
        int studentToChange = 0;
        int	sumOfGrades = 0;

        while(currCode != CODE_EXIT) {
            switch (currCode) {
                case CODE_CHANGE_GRADE:
                    System.out.println("How do you want to search the student? ");
                    System.out.println(PERSONAL_CODE + ". Id");
                    System.out.println(NAME_CODE + ". Name");
                    int searchCode = scanner.nextInt();
                    scanner.nextLine();
                    int studentId;

                    if(searchCode == PERSONAL_CODE) {
                        System.out.println("Enter the id of the changed student: ");
                        studentId = scanner.nextInt();
                        studentToChange = findStudentById(studentIds, studentId);

                        if (studentToChange > PEOPLE_NO) {
                            System.out.println("There is no student with id /" + studentId + "/ in the list");
                        }
                    }
                    else {
                        System.out.println("Enter the name of the changed student: ");
                        String changedStudent = scanner.nextLine();

                        studentToChange = findStudentByName(studentsNames, changedStudent);

                        if(studentToChange > PEOPLE_NO) {
                            System.out.println("There is no student with the name /" + changedStudent + "/ in the list");
                        }

                    }

                    if(studentToChange < PEOPLE_NO) {
                        System.out.println("Enter the new grade: ");
                        studentsGrades[currCode] = scanner.nextInt();
                        scanner.nextLine();
                    }

                    break;
                case CODE_CALC_AVARAGE:
                    // Calc the sum
                    for(int studentIndex = 0;
                        studentIndex < PEOPLE_NO;
                        ++studentIndex) {
                        sumOfGrades = studentsGrades[studentIndex];
                    }

                    float gradesAvg = (float)sumOfGrades / PEOPLE_NO;
                    System.out.println("The avarage of all grades is: " + gradesAvg);

                    break;
                // A sum calc is requested
                case CODE_CALC_SUM:
                    for(int studentIndex = 0;
                        studentIndex < PEOPLE_NO;
                        ++studentIndex) {
                        sumOfGrades += studentsGrades[studentIndex];
                    }

                    System.out.println("The sum of all grades is: " + sumOfGrades);

                case CODE_PRINT_ALL:
                    printGradesList(studentIds, studentsNames, studentsGrades);

                    break;
                case CODE_EXIT:
                    System.out.println("Good bye");

                    break;
                default:
                    System.out.println("Please enter a valid choice");

                    break;
            }

            printMenu();

            currCode = scanner.nextInt();
            scanner.nextLine();
        }
    }

}