import exceptions.DeleteBookException;
import exceptions.FullBookShelfException;
import exceptions.FullLibraryException;
import exceptions.InvalidShelfNumberException;
import library.*;
import library.books.*;

import java.util.Scanner;

public class Main {
    public static final int RETURN_BOOK_OPTION = 1;
    public static final int ADD_BOOK_OPTION = 2;
    public static final int LOST_BOOK_OPTION = 3;
    public static final int REMOVE_BOOK_OPTION = 4;
    public static final int SORT_LIBRARY_OPTION = 5;
    public static final int PRINT_LIBRARY = 6;
    public static final int EXIT_OPTION = -999;

    public static Book GetBookFromUser() {
        Scanner input = new Scanner(System.in);
        final int SCIENCE = 1;
        final int MAGAZINE = 2;
        final int READINGBOOK = 3;

        System.out.println("What is the type of the book?");
        System.out.println(SCIENCE + " - science book");
        System.out.println(MAGAZINE + " - magazine");
        System.out.println(READINGBOOK + " - reading book");
        int choice = Integer.parseInt(input.nextLine());

        System.out.println("Insert the name of the book");
        String name = input.nextLine();

        System.out.println("Insert the amount of pages");
        int pages = Integer.parseInt(input.nextLine());


         switch(choice) {
             case SCIENCE : {
                System.out.println("Insert the price of the book");
                int price = Integer.parseInt(input.nextLine());
                System.out.println("Insert the edition number of the book");
                int edition = Integer.parseInt(input.nextLine());
                System.out.println("Insert the minimum age for the book");
                int minAge = Integer.parseInt(input.nextLine());
                System.out.println("Insert the author of the book");
                String author = input.nextLine();

                return new ScienceBook(name, price, pages, edition, minAge, author);
            }
             case MAGAZINE: {
                System.out.println("Insert the price of the book");
                int price = Integer.parseInt(input.nextLine());
                System.out.println("Insert the edition number of the book");
                int edition = Integer.parseInt(input.nextLine());
                System.out.println("Insert the amount of articles inside");
                int articlesNumber = Integer.parseInt(input.nextLine());

                 return new Magazine(name, price, pages, edition, articlesNumber);
            }
             case READINGBOOK : {
                System.out.println("Insert the author of the book");
                String author = input.nextLine();
                System.out.println("Insert the cover type of the book");
                System.out.println("For Hardcover insert - " + CoverType.HARDCOVER);
                System.out.println("For Softcover insert - " + CoverType.SOFTCOVER);
                CoverType coverType = CoverType.valueOf(input.nextLine().toUpperCase());

                 return new ReadingBook(name, pages, author, coverType);
            }
             default : {
                System.out.println("Wrong input");

                 return null;
            }
        }
    }

    public static void printMenu() {
        System.out.println("What do you want to do?");
        System.out.println(RETURN_BOOK_OPTION + " - return book");
        System.out.println(ADD_BOOK_OPTION + " - add book");
        System.out.println(LOST_BOOK_OPTION + " - report a lost book");
        System.out.println(REMOVE_BOOK_OPTION + " - remove book");
        System.out.println(SORT_LIBRARY_OPTION + " - sort library");
        System.out.println(PRINT_LIBRARY + " - print library");
        System.out.println(EXIT_OPTION + " - exit");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library("The library");
        printMenu();
        int choice = Integer.parseInt(input.nextLine());

        while (choice != EXIT_OPTION) {
            switch (choice) {
                case RETURN_BOOK_OPTION: {
                    Book book = GetBookFromUser();
                    System.out.println("Insert the shelf id");
                    int shelfId = Integer.parseInt(input.nextLine());

                    try {
                        library.addBook(shelfId, book);
                    } catch (FullBookShelfException | InvalidShelfNumberException libraryException) {
                        System.out.println(libraryException.getMessage());
                    }
                }
                break;
                case ADD_BOOK_OPTION : {
                    Book book = GetBookFromUser();
                    try {
                        library.addBook(book);
                    } catch (FullLibraryException fullLibraryException) {
                        System.out.println(fullLibraryException.getMessage());
                    }
                }
                break;
                case LOST_BOOK_OPTION : {
                    System.out.println("Insert the shelf number of the lost book");
                    int shelfId = Integer.parseInt(input.nextLine());
                    System.out.println("Insert the name of the lost book");
                    String bookName = input.nextLine();
                    try {
                        library.deleteBook(shelfId, bookName);
                    } catch (DeleteBookException | InvalidShelfNumberException libraryException) {
                        System.out.println(libraryException.getMessage());
                    }
                }
                break;
                case REMOVE_BOOK_OPTION : {
                    System.out.println("Insert the name of the book");
                    String name = input.nextLine();
                    try {
                        library.deleteBook(name);
                    } catch (DeleteBookException deleteException) {
                        System.out.println(deleteException.getMessage());
                    }
                }
                break;
                case SORT_LIBRARY_OPTION : library.sort(); break;
                case PRINT_LIBRARY : library.print(); break;
                default : System.out.println("Wrong input");
            }

            printMenu();
            choice = Integer.parseInt(input.nextLine());
        }
    }
}
