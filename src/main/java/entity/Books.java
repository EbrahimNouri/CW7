package entity;

import java.util.Objects;

public class Books {
    private long id;
    private String title;
    private String text;
    private boolean isBorrowed;
    private String category;
    private double price;

    public Books(long id, String title, String text, boolean isBorrowed, String category, double price) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        Books books = (Books) o;
        return id == books.id && isBorrowed == books.isBorrowed && Double.compare(books.price, price) == 0 && Objects.equals(title, books.title) && Objects.equals(text, books.text) && Objects.equals(category, books.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, text, isBorrowed, category, price);
    }
}
