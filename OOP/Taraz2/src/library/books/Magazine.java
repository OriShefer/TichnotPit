package library.books;

public class Magazine extends RenewableBook{
    private int numberOfArticles;

    public Magazine(String name, int price, int pages, int edition, int articlesNumber){
        super(name,pages,price,edition);
        this.changeNumberOfArticles(articlesNumber);
    }

    public Magazine(Magazine magazine) {
        this(
                magazine.name(),
                magazine.price(),
                magazine.numOfPages(),
                magazine.editionNum(),
                magazine.numberOfArticles()
        );
    }

    private int numberOfArticles() {
        return numberOfArticles;
    }

    private void changeNumberOfArticles(int numberOfArticles) {
        this.numberOfArticles = numberOfArticles;
    }

    @Override
    public Book copy() {
        return new Magazine(this);
    }

    @Override
    public int averageReadingTime(){
        return super.averageReadingTime() + this.numberOfArticles();
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Number of articles: " + this.numberOfArticles());
    }
    @Override
    public int compareTo(Book o) {
        return super.name().compareTo(o.name());
    }
}
