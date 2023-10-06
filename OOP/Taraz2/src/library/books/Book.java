package library.books;

public abstract class Book implements Comparable<Book> {

    private static final float READING_TIME_CONST = 0.5f;
    private String name;
    private int numOfPages;
    private int price;

    public Book(){
        this.changeName("");
        this.changeNumOfPages(0);
        this.changePrice(0);
    }

    public Book(String name, int numOfPages, int price){
        this.changeName(name);
        this.changeNumOfPages(numOfPages);
        this.changePrice(price);
    }

    public String name() {
        return name;
    }

    private void changeName(String name) {
        this.name = name;
    }

    public int numOfPages() {
        return numOfPages;
    }

    private void changeNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public int price() {
        return price;
    }

    private void changePrice(int price) {
        this.price = price;
    }

    public abstract Book copy();

    public void print() {
        System.out.println("Name: " + this.name());
        System.out.println("Price: " + this.price());
        System.out.println("Ages: " + this.numOfPages());
    }

    public int averageReadingTime(){
        return (int) (this.numOfPages() * READING_TIME_CONST);
    }
}
