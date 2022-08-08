package services;

import entity.Book;
import entity.Category;
import entity.UserAccount;
import repository.UserRepository;
import repository.impl.BookRepositoryImpl;
import repository.impl.CategoryRepositoryImpl;
import repository.impl.UserRepositoryImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationConstant.getConnection();
        BookRepositoryImpl.createTable();
        CategoryRepositoryImpl.creatTable();
//        UserRepositoryImpl.creatTable();

        //Category category = new Category(1, "science");
        //Book book = new Book(1, "teory", "this text is teory", false, category, 6.5);
        //ApplicationConstant.getBookRepository().create(book);
        //UserAccount userAccount = new UserAccount(1,"ebi", "nouri", "");
    }
}
