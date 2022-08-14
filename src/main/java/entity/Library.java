package entity;
import java.util.List;
import java.util.Objects;

public class Library {
    private List<UserAccount> userList;
    private List<Book> bookList;
    private double allDeposit;

    public Library(List<UserAccount> userList, List<Book> bookList, double allDeposit) {
        this.userList = userList;
        this.bookList = bookList;
        this.allDeposit = allDeposit;
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

    public double getAllDeposit() {
        return allDeposit;
    }

    public void setAllDeposit(double allDeposit) {
        this.allDeposit = allDeposit;
    }

    @Override
    public String toString() {
        return "Library{" +
                "userList=" + userList +
                ", bookList=" + bookList +
                ", allDeposit=" + allDeposit +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Double.compare(library.allDeposit, allDeposit) == 0 && Objects.equals(userList, library.userList) && Objects.equals(bookList, library.bookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userList, bookList, allDeposit);
    }
}
