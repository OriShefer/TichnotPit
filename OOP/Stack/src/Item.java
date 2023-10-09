public abstract class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.updateName(name);
        this.updatePrice(price);
    }

    public Item(Item item){
        this(item.name(), item.price());
    }

    public Item(){}

    public String name() {
        return this.name;
    }
    public void updateName(String name) {
        this.name = name;
    }
    public int price() {
        return this.price;
    }
    public void updatePrice(int price) {
        this.price = price;
    }

    public void printItem() {
        System.out.println("name : " + this.name());
        System.out.println("price : " + this.price());
    }
}
