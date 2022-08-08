package services;

import repository.impl.BookRepositoryImpl;
import repository.impl.CategoryRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import services.impl.UserAccountServicesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    private static UserRepositoryImpl userRepository = new  UserRepositoryImpl();
    private static  BookRepositoryImpl bookRepository = new BookRepositoryImpl();
    private static CategoryRepositoryImpl categoryRepository = new CategoryRepositoryImpl();

    public static UserRepositoryImpl getUserRepository() {
        return userRepository;
    }
    public static BookRepositoryImpl getBookRepository(){return bookRepository;}
    public static CategoryRepositoryImpl getCategoryRepository(){return categoryRepository;}
    public static PreparedStatement preConnection(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }
}
