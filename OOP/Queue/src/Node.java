public class Node {
    private Patient data;
    private Node next;

    public Node(Patient data) {
        this.data = data;
    }

    public Patient data() {
        return data;
    }

    public void changeData(Patient data) {
        this.data = data;
    }

    public Node next() {
        return next;
    }

    public void changeNext(Node next) {
        this.next = next;
    }
}
