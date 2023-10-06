package library;

import exceptions.DeleteBookException;
import exceptions.FullBookShelfException;
import exceptions.FullLibraryException;
import exceptions.InvalidShelfNumberException;
import library.books.Book;

import java.util.ArrayList;
import java.util.Arrays;

public class Library {

  public static final int NUM_OF_SHELVES = 10;
  private BookShelf[] libShelves;
  private String libraryName;

  public Library(String name) {
    this.changeLibraryName(name);
    this.initLibShelves();
  }

  private String libraryName() {
    return this.libraryName;
  }

  public BookShelf[] libShelves() {
    return Arrays.copyOf(libShelves, NUM_OF_SHELVES);
  }

  private void changeLibraryName(String libraryName) {
    this.libraryName = libraryName;
  }

  private void initLibShelves() {
    this.libShelves = new BookShelf[NUM_OF_SHELVES];

    for (int numOfShelf = 0; numOfShelf < NUM_OF_SHELVES; numOfShelf++) {
      this.libShelves[numOfShelf] = new BookShelf(numOfShelf + 1, new ArrayList<>());
    }
  }

  private int booksInLibrary() {
    return Arrays.stream(this.libShelves()).mapToInt(BookShelf::countBooks).sum();
  }

  private int numOfPagesInLibrary() {
    return Arrays.stream(this.libShelves()).mapToInt(BookShelf::countPagesOnShelf).sum();
  }

  public void print() {
    System.out.println(this.libraryName());
    System.out.println("------------");
    boolean isLibEmpty = true;

    for (BookShelf current : this.libShelves()) {
      if (current.countBooks() != 0) {
        isLibEmpty = false;
        System.out.println("Shelf number: " + (current.shelfId()));
        current.print();
        System.out.println("=================");
      }
    }

    if (isLibEmpty) {
      System.out.println("The library is empty!");
    }

    System.out.println();
  }

  private BookShelf findBookShelfById(int shelfId) throws InvalidShelfNumberException {
    return Arrays.stream(this.libShelves())
        .filter(bookShelf -> bookShelf.shelfId() == shelfId)
        .findFirst()
        .orElseThrow(InvalidShelfNumberException::new);
  }

  public void addBook(int shelfId, Book newBook)
          throws InvalidShelfNumberException, FullBookShelfException {
    if (shelfId < 1 || shelfId > NUM_OF_SHELVES) {
      throw new InvalidShelfNumberException();
    }

    this.findBookShelfById(shelfId).addBook(newBook.copy());
  }

  public void addBook(Book newBook) throws FullLibraryException {
    boolean isBookAdded = false;

    for (BookShelf current : this.libShelves()) {
      try {
        current.addBook(newBook.copy());
        isBookAdded = true;

        break;
      } catch (FullBookShelfException e) {
        System.out.println(
            "Shelf number " + current.shelfId() + " is full, checking the next shelf");
      }
    }

    if (!isBookAdded) {
      throw new FullLibraryException();
    }
  }

  public void deleteBook(int shelfId, String bookName)
      throws DeleteBookException, InvalidShelfNumberException {
    if (shelfId < 1 || shelfId > NUM_OF_SHELVES) {
      throw new InvalidShelfNumberException();
    }

    BookShelf wantedBookShelf = this.findBookShelfById(shelfId);

    if (!wantedBookShelf.isBookOnShelf(bookName)) {
      throw new DeleteBookException();
    }

    wantedBookShelf.deleteBook(bookName);
  }

  public void deleteBook(String bookName) throws DeleteBookException {
    boolean isFoundAndDeleted = false;

    for (BookShelf currentShelf : this.libShelves()) {
      if (currentShelf.isBookOnShelf(bookName)) {
        isFoundAndDeleted = true;
        currentShelf.deleteBook(bookName);

        break;
      }
    }

    if (!isFoundAndDeleted) {
      throw new DeleteBookException();
    }
  }

  public void sort() {
    for (BookShelf currBookShelf : this.libShelves) {
      currBookShelf.sort();
    }

    Arrays.sort(this.libShelves);
  }
}
