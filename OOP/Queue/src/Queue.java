public class Queue {

    private Node head;
    private Node tail;

    public Queue(){
        changeHead(null);
        changeTail(null);
    }

    public Node getHead() {
        return head;
    }

    public void changeHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void changeTail(Node tail) {
        this.tail = tail;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void enqueue(Patient toAdd){
        Node newNode = new Node(toAdd);

        if(this.isEmpty()){
            this.changeHead(newNode);
            this.changeTail(newNode);
        }else{
            this.tail.changeNext(newNode);
            this.changeTail(newNode);
        }

    }

    public Node dequeue (){
        if (this.getHead() == this.getTail())
            this.changeTail(null);

        Node res = this.getHead();

        if (this.head() != null)
            this.changeHead(this.getHead().next());

        return res;
    }

    public Patient head(){

        if(this.isEmpty())
            return null;

        return this.getHead().data();
    }

    public void printQueue(){
        Node current = this.getHead();

        while(current != null){
            current.data().printPatient();
            System.out.println();
            current = current.next();
        }
    }

    public int calcLength(){
        int length = 0;
        Node current = this.getHead();
        while (current != null) {
            length++;
            current = current.next();
        }

        return length;
    }

}
