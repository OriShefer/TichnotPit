public class Main {
    public static void main(String[] args) {

        Shelf shelf = new Shelf();

        shelf.addToLeftSide(new Marker("marker",1,"yellow"));
        shelf.addToLeftSide(new Marker("marker",5,"yellow"));
        shelf.addToLeftSide(new Marker("marker",2,"yellow"));
        shelf.addToLeftSide(new Marker("marker",8,"yellow"));

        shelf.addToRightSide(new Pen("pen",1,1));
        shelf.addToRightSide(new Pen("pen",2,2));

        shelf.printItems();

        shelf.sortLeftSide();
        System.out.println("-----------------------------");
        shelf.printItems();

    }
}