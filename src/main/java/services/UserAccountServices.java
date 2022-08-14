package services;

import entity.Usertype;

import java.sql.SQLException;

public interface UserAccountServices {


    public double priceCal(Usertype usertype, double price);
    void login() throws SQLException;
    void signUp();
    boolean checkNatCode(String natCode);
}