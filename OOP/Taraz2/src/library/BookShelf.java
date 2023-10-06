package library;

import exceptions.DeleteBookException;
import exceptions.FullBookShelfException;
import library.books.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;

public class BookShelf implements Comparable<BookShelf> {

	private static final int MAX_NUM_OF_PAGES = 1500;
	private static final int MAX_NUM_OF_BOOKS = 5;

	private int shelfId;
	private ArrayList<Book> booksOnShelf;

	public BookShelf(int shelfID, ArrayList<Book> bookShelf) {
		this.changeShelfId(shelfID);
		this.changeBooksOnShelf(bookShelf);
	}

	public int shelfId() {
		return this.shelfId;
	}

	private ArrayList<Book> booksOnShelf() {
		return new ArrayList<>(this.booksOnShelf);
	}

	private void changeShelfId(int shelfId) throws InputMismatchException {
		if (shelfId <= 0) {
			throw new InputMismatchException("Shelf ID must be positive");
		}
		this.shelfId = shelfId;
	}

	private void changeBooksOnShelf(ArrayList<Book> booksOnShelf) {
		this.booksOnShelf = new ArrayList<>(booksOnShelf);
	}

	public void addBook(Book newBook) throws FullBookShelfException {
		if(this.countBooks() == MAX_NUM_OF_BOOKS)
			throw new FullBookShelfException();
		if(this.countPagesOnShelf() + newBook.numOfPages() > MAX_NUM_OF_PAGES)
			throw new FullBookShelfException();

		this.booksOnShelf.add(newBook);

	}

	public boolean isBookOnShelf(String bookName) {

		for(Book book : this.booksOnShelf())
			if(book.name().equals(bookName))
				return true;

		return false;

	}

	public void deleteBook(String bookName) {
		this.booksOnShelf.removeIf(book -> book.name().equals(bookName));
	}

	public int countBooks() {
		return this.booksOnShelf.size();
	}

	public int countPagesOnShelf() {
		int sum = 0;
		for(Book book : this.booksOnShelf)
			sum += book.numOfPages();
		return sum;
	}

	public void sort() {
		Collections.sort(this.booksOnShelf());
	}

	public void print() {
		for(int i = 0; i < this.booksOnShelf().size(); i++){
			System.out.println();
			System.out.println("Book number "+(i+1) + ":");
			this.booksOnShelf().get(i).print();
		}

	}

	@Override
	public int compareTo(BookShelf toCompare) {

		int result;

		if ((this.booksOnShelf().isEmpty()) && (toCompare.booksOnShelf().isEmpty())) {
			return 0;
		} else if (this.booksOnShelf().isEmpty()) {
			return -1;
		} else if (toCompare.booksOnShelf().isEmpty()) {
			return 1;
		}

		return this.booksOnShelf().get(0).compareTo(toCompare.booksOnShelf().get(0));
	}
}
