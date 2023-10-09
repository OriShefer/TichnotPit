public class Pen extends Item {
    private int thickness;

    public Pen(String name, int price, int thickness) {
        super(name, price);
        this.updateThickness(thickness);
    }

    public Pen() {
        super();
    }

    public int thickness() {
        return this.thickness;
    }

    public void updateThickness(int thickness) {
        this.thickness = thickness;
    }

    @Override
    public void printItem() {
        super.printItem();
        System.out.println("thickness : " + this.thickness());
    }
}
