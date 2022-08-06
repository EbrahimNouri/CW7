package services;

import entity.Usertype;

public interface UserAccountServices {


    public double priceCal(Usertype usertype, double price);
    void login();
    void signUp();
    boolean checkNatCode(String natCode);
}