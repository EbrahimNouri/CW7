package services;

import entity.Book;
import entity.Category;
import repository.impl.BookRepositoryImpl;
import repository.impl.CategoryRepositoryImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationConstant.getConnection();
        BookRepositoryImpl.createTable();
        CategoryRepositoryImpl.creatTable();
        //Category category = new Category(1, "science");
        //Book book = new Book(1, "teory", "this text is teory", false, category, 6.5);
        //ApplicationConstant.getBookRepository().create(book);
    }
}
