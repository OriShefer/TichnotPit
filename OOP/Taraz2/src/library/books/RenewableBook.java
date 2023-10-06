package library.books;

public abstract class RenewableBook extends Book {

    private int editionNum;

    public RenewableBook(String name, int price, int pages, int edition){
        super(name,pages,price);
        this.changeEditionNum(edition);
    }

    public int editionNum() {
        return editionNum;
    }

    private void changeEditionNum(int editionNum) {
        this.editionNum = editionNum;
    }
}
