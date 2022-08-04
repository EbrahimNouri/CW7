package services;

import entity.UserAccount;
import services.impl.UserAccountServicesImpl;

import java.sql.Connection;
import java.util.Scanner;

public class ApplicationConstant {
    private static UserAccountServices userAccountServices = new UserAccountServicesImpl();
    public static UserAccountServices getUserAccountServices() {
        return userAccountServices;
    }

    private static Connection connection = new DBHelper().connect();
    public static Connection getConnection() {return connection;}
    public static Scanner input = new Scanner(System.in);
    public  static Scanner getInput(){return input;}
}
