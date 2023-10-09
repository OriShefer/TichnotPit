import java.util.Stack;

public class Shelf {

    private Stack<Item> pens;
    private Stack<Item> markers;

    public Shelf(){
        this.pens = new Stack<Item>();
        this.markers = new Stack<Item>();
    }

    public Stack<Item> pens() {
        Stack<Item> newStack = new Stack<>();
        newStack.addAll(this.pens);

        return newStack;
    }

    public void updatePens(Stack<Item> pens) {
        Stack<Item> newStack = new Stack<>();
        newStack.addAll(pens);
        this.pens = newStack;
    }


    public Stack<Item> markers() {
        Stack<Item> newStack = new Stack<>();
        newStack.addAll(this.markers);

        return newStack;
    }

    public void updateMarkers(Stack<Item> markers) {
        Stack<Item> newStack = new Stack<>();
        newStack.addAll(markers);
        this.markers = newStack;
    }

    public void addToLeftSide(Item item) {
        if (item instanceof Marker) {
            this.markers.push(item);
        }
    }

    public void addToRightSide(Item item) {
        if (item instanceof Pen) {
            this.pens.push(item);
        }
    }

    public void printItemsStack(Stack<Item> items) {
        Stack<Item> tempStack = new Stack<>();

        while (!items.isEmpty()) {
            Item tempItem = items.pop();
            tempItem.printItem();
            tempStack.push(tempItem);
        }

        while (!tempStack.isEmpty()) {
            items.push(tempStack.pop());
        }
    }
    public void printItems() {
        System.out.println("Pens List!");
        this.printItemsStack(this.pens());
        System.out.println("\nMarkers List!");
        this.printItemsStack(this.markers());

    }

    public void sortMarkersByPrice(){
        Stack<Item> tmpStack = new Stack<Item>();
        while(!this.markers.isEmpty())
        {
            // pop out the first element
            Item tmp = this.markers.pop();

            // while temporary stack is not empty and
            // top of stack is lesser than temp
            while(!tmpStack.isEmpty() && tmpStack.peek().price()
                    < tmp.price())
            {
                // pop from temporary stack and
                // push it to the input stack
                this.markers.push(tmpStack.pop());
            }

            // push temp in temporary of stack
            tmpStack.push(tmp);
        }
        this.updateMarkers(tmpStack);
    }

    public void sortPensByPrice(){
        Stack<Item> tmpStack = new Stack<Item>();
        while(!this.pens.isEmpty())
        {
            // pop out the first element
            Item tmp = this.pens.pop();

            // while temporary stack is not empty and
            // top of stack is lesser than temp
            while(!tmpStack.isEmpty() && tmpStack.peek().price()
                    < tmp.price())
            {
                // pop from temporary stack and
                // push it to the input stack
                this.pens.push(tmpStack.pop());
            }

            // push temp in temporary of stack
            tmpStack.push(tmp);
        }
        this.updateMarkers(tmpStack);
    }

    public void switchStacks() {
        Stack<Item> tempStack = new Stack<>();

        while (!this.markers.isEmpty()) {
            tempStack.push(this.markers.pop());
        }

        int penCount = this.pens.size();

        while (!this.pens.isEmpty()) {
            tempStack.push(this.pens.pop());
        }

        for (int currPen = 0; currPen < penCount; currPen++) {
            this.markers.push(tempStack.pop());
        }

        while (!tempStack.isEmpty()) {
            this.pens.push(tempStack.pop());
        }
    }

    public void headMostExpensivePen() {
        Stack<Item> tempStack = new Stack<>();
        Pen mostExpensive = new Pen();
        int maxPrice = 0;

        while (!this.pens.isEmpty()) {
            Pen tempPen = (Pen) this.pens.peek();
            this.pens.pop();

            if (tempPen.price() > maxPrice) {
                maxPrice = tempPen.price();
                mostExpensive = tempPen;
            }

            tempStack.push(tempPen);
        }

        while (!tempStack.isEmpty()) {
            Pen tempPen = (Pen) tempStack.peek();
            tempStack.pop();

            if (!(tempPen.name().equals(mostExpensive.name()))) {
                this.pens.push(tempPen);
            }
        }

        this.pens.push(mostExpensive);
    }


}
