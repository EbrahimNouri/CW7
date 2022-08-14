package repository.impl;

import entity.Book;
import entity.Category;
import entity.Library;
import repository.BaseRepository;
import repository.LibraryRepository;
import services.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LibraryRepositoryImpl implements LibraryRepository, BaseRepository<Library> {
//todo fix
    @Override
    public Library create(Library library) throws SQLException {
        String sql = "select * from user_account";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
//        while (rs.){
//            library.
//        }
        return null;
    }

    @Override
    public Library read(Library library) throws SQLException {
        return null;
    }


    @Override
    public Library update(Library library) {

        return null;
    }


    @Override
    public void addToLibrary() {

    }

    @Override
    public void deleteOfLibrary() {

    }

    @Override
    public List<Book> findBooksByCategory(Category category) {

        return null;
    }

    @Override
    public Book findBookById(Long id) {
        return null;
    }

    @Override
    public List<Book> findAllBooks() {
        return null;
    }

    @Override
    public List<Book> booksBorrowed() {
        return null;
    }

    public static void creatTable() throws SQLException {
        String sql = "create table if not exists library()";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);


    }
}
