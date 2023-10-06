package library.books;

public class ScienceBook extends RenewableBook{

    private String author;
    private int minAge;

    public ScienceBook(String name, int price, int pages, int edition, int minAge, String author){
        super(name,price,pages,edition);
        this.changeAuthor(author);
        this.changeMinAge(minAge);
    }

    public ScienceBook(ScienceBook scienceBook) {
        this(
                scienceBook.name(),
                scienceBook.price(),
                scienceBook.numOfPages(),
                scienceBook.editionNum(),
                scienceBook.minAge(),
                scienceBook.author()
        );
    }

    private String author() {
        return author;
    }

    private void changeAuthor(String author) {
        this.author = author;
    }

    private int minAge() {
        return minAge;
    }

    private void changeMinAge(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public Book copy() {
        return new ScienceBook(this);
    }


    @Override
    public void print() {
        super.print();
        System.out.println("Minimum age: " + this.minAge());
        System.out.println("Author: " + this.author());
    }

    @Override
    public int averageReadingTime(){
        return super.averageReadingTime() - this.minAge();
    }

    @Override
    public int compareTo(Book o) {
        return super.name().compareTo(o.name());

    }
}
