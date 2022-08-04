package entity;

import java.util.Objects;

public class UserAccount extends Person{
    Usertype usertype;
    private String username;
    private String password;
    private boolean isBlocked;
    private double credit;
    private String dor;
    private int borrowedNum;
    private int reserveNum;
    private int returnedNum;

    public UserAccount() {
    }

    public UserAccount(long id, String firstname, String lastName, String birthday, Usertype usertype, String username, String password, boolean isBlocked, double credit, String dor, int borrowedNum, int reserveNum, int returnedNum) {
        super(id, firstname, lastName, birthday);
        this.usertype = usertype;
        this.username = username;
        this.password = password;
        this.isBlocked = isBlocked;
        this.credit = credit;
        this.dor = dor;
        this.borrowedNum = borrowedNum;
        this.reserveNum = reserveNum;
        this.returnedNum = returnedNum;
    }

    public UserAccount(Usertype usertype, String username, String password, boolean isBlocked, double credit, String dor, int borrowedNum, int reserveNum, int returnedNum) {
        this.usertype = usertype;
        this.username = username;
        this.password = password;
        this.isBlocked = isBlocked;
        this.credit = credit;
        this.dor = dor;
        this.borrowedNum = borrowedNum;
        this.reserveNum = reserveNum;
        this.returnedNum = returnedNum;
    }

    public Usertype getUsertype() {
        return usertype;
    }

    public void setUsertype(Usertype usertype) {
        this.usertype = usertype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getDor() {
        return dor;
    }

    public void setDor(String dor) {
        this.dor = dor;
    }

    public int getBorrowedNum() {
        return borrowedNum;
    }

    public void setBorrowedNum(int borrowedNum) {
        this.borrowedNum = borrowedNum;
    }

    public int getReserveNum() {
        return reserveNum;
    }

    public void setReserveNum(int reserveNum) {
        this.reserveNum = reserveNum;
    }

    public int getReturnedNum() {
        return returnedNum;
    }

    public void setReturnedNum(int returnedNum) {
        this.returnedNum = returnedNum;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "usertype=" + usertype +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isBlocked=" + isBlocked +
                ", credit=" + credit +
                ", dor='" + dor + '\'' +
                ", borrowedNum=" + borrowedNum +
                ", reserveNum=" + reserveNum +
                ", returnedNum=" + returnedNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserAccount that = (UserAccount) o;
        return isBlocked == that.isBlocked && Double.compare(that.credit, credit) == 0 && borrowedNum == that.borrowedNum && reserveNum == that.reserveNum && returnedNum == that.returnedNum && usertype == that.usertype && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(dor, that.dor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), usertype, username, password, isBlocked, credit, dor, borrowedNum, reserveNum, returnedNum);
    }

}
