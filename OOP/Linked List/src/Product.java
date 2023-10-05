import java.util.Date;

public class Product {
    private int price;
    private String name;
    private Date expiration;

    public Product(int price, String name, Date expiration) {
        this.changePrice(price);
        this.changeName(name);
        this.changeExpiration(expiration);
    }

    public int price() {
        return this.price;
    }

    private void changePrice(int price) {
        this.price = price;
    }

    public String name() {
        return this.name;
    }

    private void changeName(String name) {
        this.name = name;
    }

    public Date expiration() {
        return (Date) this.expiration.clone();
    }

    private void changeExpiration(Date expiration) {
        this.expiration = (Date) expiration.clone();
    }

    public boolean isExpired() {
        return new Date().after(this.expiration());
    }

    @Override
    public String toString() {
        return "Product {" +
                "price = " + price +
                ", name = '" + name + '\'' +
                ", expiration = " + expiration +
                '}';
    }
}
