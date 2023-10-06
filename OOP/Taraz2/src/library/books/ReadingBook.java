package library.books;

import library.CoverType;

public class ReadingBook extends Book {
    private static final int PRICE_FACTOR = 3;

    private String author;
    private CoverType coverType;

    public ReadingBook(String name, int numOfPages, String author, CoverType coverType){
        super(name, numOfPages, numOfPages * PRICE_FACTOR);
        this.changeAuthor(author);
        this.changeCoverType(coverType);
    }

    public ReadingBook(ReadingBook readingBook) {
        this(
                readingBook.name(),
                readingBook.numOfPages(),
                readingBook.author(),
                readingBook.coverType()
        );
    }

    private String author() {
        return author;
    }

    private void changeAuthor(String author) {
        this.author = author;
    }

    private CoverType coverType() {
        return coverType;
    }

    private void changeCoverType(CoverType coverType) {
        this.coverType = coverType;
    }

    @Override
    public int compareTo(Book o) {
        return super.name().compareTo(o.name());

    }

    @Override
    public void print() {
        super.print();
        System.out.println("Author: " + this.author());
        System.out.println("Cover type: " + this.coverType());
    }

    @Override
    public Book copy() {
        return new ReadingBook(this);
    }
}
