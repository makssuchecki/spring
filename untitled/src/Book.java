public class Book {
    private String name;
    private Author author;
    private double price;
    private int qty;

    public Book(String name, double price, Author author) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.qty = 0;
    }

    public Book(String name, double price, Author author, int qty) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return String.format("Book[name=%s,author=%s,price=%.2f,qty=%d]", name, author, price, qty);
    }
}