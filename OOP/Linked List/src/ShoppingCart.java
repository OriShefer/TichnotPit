public class ShoppingCart {
    private Node head;

    public ShoppingCart(){
        this.head = null;
    }


    public void add(Product product){

        Node newProduct = new Node(product);

        if(this.head == null)
            this.head = newProduct;
        else{
            Node currentNode = this.head;

            while(currentNode.getNext() != null)
                currentNode = currentNode.getNext();

            currentNode.setNext(newProduct);
        }



    }

    public void removeLast(){

        if(this.head.getNext() == null)
            this.head = null;
        else{
            Node currentNode = this.head;

            while(currentNode.getNext().getNext() != null)
                currentNode = currentNode.getNext();

            currentNode.setNext(null);
        }
    }

    public void removeProduct(Product product){

        if(this.head.getNext() == null && this.head.getProduct() == product)
            this.head = null;
        else{
            Node currentNode = this.head;

            while(currentNode.getNext().getProduct() != product)
                currentNode = currentNode.getNext();

            currentNode.setNext(currentNode.getNext().getNext());
        }

    }

    public void deleteAll(){
        this.head = null;
    }

    public int productCount(){
        Node currentNode = this.head;
        int count = 0;

        while (currentNode != null){
            count++;
            currentNode = currentNode.getNext();
        }

        return count;
    }

    public void printCart(){
        Node currentNode = this.head;

        while (currentNode != null){
            System.out.println(currentNode.getProduct().toString());
            currentNode = currentNode.getNext();
        }

    }

    public int getTotalPrice(){
        Node currentNode = this.head;
        int totalPrice = 0;

        while (currentNode != null){
            totalPrice += currentNode.getProduct().price();
            currentNode = currentNode.getNext();

        }

        return totalPrice;
    }

    public ShoppingCart getExpired(){
        ShoppingCart shoppingCart = new ShoppingCart();
        Node currentNode = this.head;

        while(currentNode != null){

            if(currentNode.getProduct().isExpired())
                shoppingCart.add(currentNode.getProduct());

            currentNode = currentNode.getNext();
        }

        return shoppingCart;

    }
}
