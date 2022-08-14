package services;

import entity.UserAccount;
import entity.Usertype;
import repository.impl.BookRepositoryImpl;
import repository.impl.CategoryRepositoryImpl;
import repository.impl.UserRepositoryImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationConstant.getConnection();
        BookRepositoryImpl.createTable();
        CategoryRepositoryImpl.creatTable();

//        UserAccount ahmad = new UserAccount(5, "ali", "babai", "1999/4/3", Usertype.STUDENT_USER, "alireza", "0123", false, 12.0, "salam", 12, 12, 12);
//        ApplicationConstant.getUserRepository().create(ahmad);
        UserAccount userAccount;
//        ApplicationConstant.getUserRepository().read();

        //Category category = new Category(1, "science");
        //Book book = new Book(1, "teory", "this text is teory", false, category, 6.5);
        //ApplicationConstant.getBookRepository().create(book);
        //UserAccount userAccount = new UserAccount(1,"ebi", "nouri", "");
    }
}
