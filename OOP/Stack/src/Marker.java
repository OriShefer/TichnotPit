public class Marker extends Item {
    private String color;

    public Marker(String name, int price, String color) {
        super(name, price);
        this.updateColor(color);
    }

    public String color() {
        return this.color;
    }

    public void updateColor(String color) {
        this.color = color;
    }

    @Override
    public void printItem() {
        super.printItem();
        System.out.println("color : " + this.color());
    }
}
