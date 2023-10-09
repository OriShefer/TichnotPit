
public class Stack {
    private Node head;

    public boolean isEmpty() {
        return this.head == null;
    }

    public void push(Item item) {
        Node newNode = new Node(item);

        if(this.head == null)
            this.head = newNode;
        else{
            Node temp = this.head;
            this.head = newNode;
            newNode.updateNext(temp);
        }
    }

    public Node top() {
        return this.head;
    }

    public Node pop() {
        if(this.head == null){
            return null;
        }
        else{
            Node temp = this.head;
            this.head = this.head.next();
            return temp;
        }
    }

    public void printStack(){
        Node current = this.head;

        while(current != null){
            current.item().printItem();
            System.out.println();
            current = current.next();
        }

    }
}
