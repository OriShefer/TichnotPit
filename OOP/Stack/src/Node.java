public class Node {
    private Item item;
    private Node next;

    public Node(Item item) {
        this.updateItem(item);
        this.updateNext(null);
    }

    public Item item() {
        return this.item;
    }

    public void updateItem(Item item) {
        this.item = item;
    }

    public Node next() {
        return this.next;
    }

    public void updateNext(Node next) {
        this.next = next;
    }
}
