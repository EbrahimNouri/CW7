package entity;



import java.util.Objects;

public class Book {
    private long id;
    private String title;
    private String text;
    private boolean isBorrowed;
    private Category category;
    private double price;

    public Book(long id, String title, String text, boolean isBorrowed, Category category, double price) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.isBorrowed = isBorrowed;
        this.category = category;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category =  category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", isBorrowed=" + isBorrowed +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && isBorrowed == book.isBorrowed && Double.compare(book.price, price) == 0 && Objects.equals(title, book.title) && Objects.equals(text, book.text) && Objects.equals(category, book.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, text, isBorrowed, category, price);
    }
}
