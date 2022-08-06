package entity;

import java.util.List;
import java.util.Objects;

public class Library {
    private List<UserAccount> userList;
    private List<Book> bookList;
    private double allDeposite;

    public Library(List<UserAccount> userList, List<Book> bookList, double allDeposite) {
        this.userList = userList;
        this.bookList = bookList;
        this.allDeposite = allDeposite;
    }

    public List<UserAccount> getUserList() {
        return userList;
    }

    public void setUserList(List<UserAccount> userList) {
        this.userList = userList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public double getAllDeposite() {
        return allDeposite;
    }

    public void setAllDeposite(double allDeposite) {
        this.allDeposite = allDeposite;
    }

    @Override
    public String toString() {
        return "Library{" +
                "userList=" + userList +
                ", bookList=" + bookList +
                ", allDeposite=" + allDeposite +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Double.compare(library.allDeposite, allDeposite) == 0 && Objects.equals(userList, library.userList) && Objects.equals(bookList, library.bookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userList, bookList, allDeposite);
    }
}
