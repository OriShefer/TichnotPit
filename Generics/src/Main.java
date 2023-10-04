public class Main {
    public static void main(String[] args) {

        Integer[] arr = {211,22,13};
        LinkedList<Integer> listInt = new LinkedList<Integer>(arr);
        listInt.printLinkedList();

        String[] strArr = {"ori", "maya"};
        LinkedList<String> listString = new LinkedList<String>(strArr);
        listString.printLinkedList();

        printLonger(listString,4);

    }

    public static <T> void reverseLinkedList(LinkedList<T> list){

        LinkedListNode<T> previous = null;
        LinkedListNode<T> current = list.getHead();
        LinkedListNode<T> next;

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        list.setHead(previous);


    }

    public static <T> void printLonger(LinkedList<T> list, int length){

        LinkedListNode<T> current = list.getHead();
        while (current != null){
            if(current.getData().toString().length() >= length)
                System.out.println(current.getData());
            current = current.getNext();
        }


    }


}