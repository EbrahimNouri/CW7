package services;

import java.sql.Connection;
import java.util.Scanner;

public class ApplicationConstant {
    private static Connection connection = new DBHelper().connect();
    public static Connection getConnection() {return connection;}
    public static Scanner input = new Scanner(System.in);
    public  static Scanner getInput(){return input;}
}
