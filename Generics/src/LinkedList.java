public class LinkedList<T> {
    private LinkedListNode<T> head;

    public LinkedList(){
        this.head = null;
    }

    public LinkedList(T[] data){
        for(T data1: data){
            add(data1);
        }
    }

    public LinkedListNode<T> getHead(){
        return this.head;
    }

    public void setHead(LinkedListNode<T> head){
        this.head = head;
    }



    public void add(T data){

        LinkedListNode<T> newData = new LinkedListNode<T>(data);

        if(this.head == null)
            this.head = newData;
        else{
            LinkedListNode<T> currentNode = this.head;

            while(currentNode.getNext() != null)
                currentNode = currentNode.getNext();

            currentNode.setNext(newData);
        }



    }

    public void removeLast(){

        if(this.head.getNext() == null)
            this.head = null;
        else{
            LinkedListNode<T> currentNode = this.head;

            while(currentNode.getNext().getNext() != null)
                currentNode = currentNode.getNext();

            currentNode.setNext(null);
        }
    }

    public void removeData(T data){

        if(this.head.getNext() == null)
            this.head = null;

        if(this.head.getData().equals(data)){
            this.head = this.head.getNext();
        }
        else{
            LinkedListNode<T> currentNode = this.head;

            while(currentNode.hasNext() && !currentNode.getNext().getData().equals(data))
                currentNode = currentNode.getNext();

            currentNode.setNext(currentNode.getNext().getNext());
        }

    }

    public void deleteAll(){
        this.head = null;
    }

    public int listCount(){
        LinkedListNode<T> currentNode = this.head;
        int count = 0;

        while (currentNode != null){
            count++;
            currentNode = currentNode.getNext();
        }

        return count;
    }

    public void printLinkedList(){
        LinkedListNode<T> currentNode = this.head;

        while (currentNode != null){
            System.out.print(currentNode.getData().toString() + " --> ");
            currentNode = currentNode.getNext();
        }
        System.out.println();

    }

}
