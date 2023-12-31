public class LinkedListNode<T> {
  private T data;
  private LinkedListNode<T> next;

  public LinkedListNode(T data) {
    this.data = data;
    this.next = null;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public LinkedListNode<T> getNext() {
    return next;
  }

  public void setNext(LinkedListNode<T> next) {
    this.next = next;
  }

  public boolean hasNext(){
    return this.next != null;
  }


  @Override
  public String toString() {
    return "Node {" +
            "data = " + this.getData() +
            ", next = " + this.getNext() +
            '}';
  }

}
